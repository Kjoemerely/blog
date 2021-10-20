var blogEditor;
// Tags Input
$('#blogTags').tagsInput({
    width: '100%',
    height: '38px',
    defaultText: '文章标签'
});

//Initialize Select2 Elements
$('.select2').select2()

$(function () {
    blogEditor = editormd("blog-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "/admin/plugins/editormd/lib/",
        toolbarModes: 'full',
        /**图片上传配置*/
        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"], //图片上传格式
        imageUploadURL: "/article/md/uploadFile",
        onload: function (obj) { //上传成功之后的回调
        }
    });

    // 编辑器粘贴上传
    document.getElementById("blog-editormd").addEventListener("paste", function (e) {
        var clipboardData = e.clipboardData;
        if (clipboardData) {
            var items = clipboardData.items;
            if (items && items.length > 0) {
                for (var item of items) {
                    if (item.type.startsWith("image/")) {
                        var file = item.getAsFile();
                        if (!file) {
                            alert("请上传有效文件");
                            return;
                        }
                        var formData = new FormData();
                        formData.append('file', file);
                        var xhr = new XMLHttpRequest();
                        xhr.open("POST", "/upload/file");
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState == 4 && xhr.status == 200) {
                                var json=JSON.parse(xhr.responseText);
                                if (json.resultCode == 200) {
                                    blogEditor.insertValue("![](" + json.data + ")");
                                } else {
                                    alert("上传失败");
                                }
                            }
                        }
                        xhr.send(formData);
                    }
                }
            }
        }
    });

    new AjaxUpload('#uploadCoverImage', {
        action: '/upload/file',
        name: 'file',
        enctype: 'multipart/form-data',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.code == '0') {
                $("#coverImage").attr("src", r.data);
                $("#coverImage").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    });
});

$('#confirmButton').click(function () {
    var title = $('#blogTitle').val();
    console.log(title);
    // var blogSubUrl = $('#blogSubUrl').val();
    var categoryId = $('#categoryId').val();
    var tagIds = $('#tagIds').val();
    var content = blogEditor.getMarkdown();
    if (isNull(title)) {
        swal("请输入文章标题", {
            icon: "error",
        });
        return;
    }
    if (!validLength(title, 150)) {
        swal("标题过长", {
            icon: "error",
        });
        return;
    }
    // if (!validLength(blogSubUrl, 150)) {
    //     swal("路径过长", {
    //         icon: "error",
    //     });
    //     return;
    // }
    if (isNull(categoryId)) {
        swal("请选择文章分类", {
            icon: "error",
        });
        return;
    }
    // if (isNull(tagIds)) {
    //     swal("请输入文章标签", {
    //         icon: "error",
    //     });
    //     return;
    // }
    if (!validLength(tagIds, 150)) {
        swal("标签过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(content)) {
        swal("请输入文章内容", {
            icon: "error",
        });
        return;
    }
    if (!validLength(content, 100000)) {
        swal("文章内容过长", {
            icon: "error",
        });
        return;
    }
    $('#articleModal').modal('show');
});

$('#saveButton').click(function () {
    var id = $('#blogId').val();
    var title = $('#blogName').val();
    // var blogSubUrl = $('#blogSubUrl').val();
    var categoryId = $('#blogCategoryId').val();
    var tagIds = $('#blogTags').val();
    var content = blogEditor.getMarkdown();
    var coverImage = $('#blogCoverImage')[0].src;
    var status = $("input[name='blogStatus']:checked").val();
    var enableComment = $("input[name='enableComment']:checked").val();
    if (isNull(coverImage) || coverImage.indexOf('img-upload') !== -1) {
        swal("封面图片不能为空", {
            icon: "error",
        });
        return;
    }
    var url = '/article/save';
    var swlMessage = '保存成功';
    var data = {
        "title": title,
        // "blogSubUrl": blogSubUrl,
        "categoryId": categoryId,
        "tagIds": tagIds,
        "content": content,
        "coverImage": coverImage,
        "status": status,
        "enableComment": enableComment
    };
    if (id > 0) {
        url = '/admin/blogs/update';
        swlMessage = '修改成功';
        data = {
            "id": id,
            "title": title,
            // "blogSubUrl": blogSubUrl,
            "categoryId": categoryId,
            "tagIds": tagIds,
            "content": content,
            "coverImage": coverImage,
            "status": status,
            "enableComment": enableComment
        };
    }
    console.log(data);
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        data: data,
        success: function (result) {
            if (result.code == '0') {
                $('#articleModal').modal('hide');
                swal({
                    title: swlMessage,
                    type: 'success',
                    showCancelButton: false,
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: '返回博客列表',
                    confirmButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then(function () {
                    window.location.href = "/article/getArticlePage";
                })
            }
            else {
                $('#articleModal').modal('hide');
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

$('#cancelButton').click(function () {
    window.location.href = "/article/getArticlePage";
});

/**
 * 随机封面功能
 */
$('#randomCoverImage').click(function () {
    var rand = parseInt(Math.random() * 40 + 1);
    $("#blogCoverImage").attr("src", '/admin/dist/img/rand/' + rand + ".jpg");
    $("#blogCoverImage").attr("style", "width:160px ;height: 120px;display:block;");
});
