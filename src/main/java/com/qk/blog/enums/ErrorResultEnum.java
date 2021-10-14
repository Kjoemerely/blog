package com.qk.blog.enums;

import com.qk.blog.common.Result;
import com.qk.blog.exception.ResultException;

/**
 * @author qk
 * @since 2021/10/14 16:29
 */
public enum ErrorResultEnum {

    /**
     * 用户管理 01
     * 权限管理 02
     * 应用管理 03
     * 接口管理 04
     * 监控管理 05
     * 系统管理 06
     * 单点登录 07
     * 工作流 08
     */

    /**
     * 用户管理
     */
    USER_LOGIN_USER_INFO_ERROR("0101001","用户名或密码错误"),
    USER_LOGIN_LOCK("0101002","该账户用户信息已锁定，无法进行登录"),
    USER_LOGIN_CODE_FAILURE("0101003","验证码失效，请重新生成验证码"),
    USER_LOGIN_CODE_ERROR("0101004","验证码错误，请重新输入"),
    USER_LOGIN_REMOTE_ERROR("0101005","登录信息已在别处登录"),
    USER_LOGIN_TIME_EXPIRED("0101005","登录信息已过期，请重新登录"),
    USER_LOGIN_USER_EXIST("0101006","账号已存在，请重试"),
    USER_LOGIN_COUNT_LOCK("0101007","登录次数超过3次，账号将被锁定请联系管理员"),
    USER_PWD_ERROR("0101008","请输入正确的密码"),
    TEAM_HAS_BELONG_ERROR("0101009","该组织存在直属下级组织，请先删除直属下级组织"),
    TEAM_HAS_UNDER_ERROR("0101010","该组织存在关联下级组织，请先删除关联下级组织"),
    USER_LOGIN_PHONE_EXIST("0101012","固定电话已存在，请重试"),
    USER_LOGIN_MOBILE_EXIST("0101013","移动电话已存在，请重试"),
    USER_LOGIN_EMAIL_EXIST("0101014","邮箱已存在，请重试"),
    TEAM_HAS_BELONG_USER_ERROR("0101015","该组织存在用户信息，请先删除用户信息"),
    TEAM_HAS_UNDER_USER_ERROR("0101016","该组织存在关联用户信息，请先删除关联用户信息"),
    TEAM_NAME_REPEAT_ERROR("0101017","该公司下存在相同组织名称，请修改组织名称"),
    USER_LOGIN_DEFAULT_PASSWORD("0101018","当前为默认密码，请修改"),
    USER_LOGIN_NOT_ROLE("0101019","该登录用户暂无访问权限"),
    USER_NOT_SELECT_INFO("0101020","用户信息无法找到"),
    USER_IMPORT_REQUIRED("0101021","有必填项未填写"),

    /**
     * 权限管理
     */
    COMPANY_CHILD_EXIST("0201001","当前公司下存在其他部门，请删除后重试"),
    COMPANY_NAME_EXIST("0201002","当前注册的公司名已存在"),
    COMPANY_CREDIT_NO_EXIST("0201003","社会信用代码已存在"),
    TREE_CHILD_EXIST("0201004","该节点下存在其他节点，请删除后重试"),
    TREE_NAME_TREE("0201005","已存在相同名字的节点"),
    ROLE_CHILD_EXIST("0201006","当前角色或角色组下存在其他角色，请删除后重试"),
    ROLE_GROUP_EXIST_ROLE_NAME("0201007","当前角色组下存在相同的名字的角色"),
    ROLE_GROUP_EXIST_NAME("0201008","已存在相同名字的角色组"),
    RES_GROUP_NAME_REPEAT_ERROR("0201009","已存在该名称的资源组信息"),
    RES_NAME_REPEAT_ERROR("0201010","已存在该名称的资源信息"),
    RES_CODE_REPEAT_ERROR("0201011","同应用下资源编码不允许重复，请重新填写资源编码"),
    RES_USER_COUNT_OUT_ERROR("0201012","批量用户授权最多只允许1000人"),
    ROLE_ID_EXIST("0201013","角色标识已存在"),
    RES_HAS_LOWER_RES_ERROR("0201014","当前资源或资源组下存在其他资源，请删除后重试"),
    RES_HAS_ROLE_ERROR("0201015","当前资源下存在角色关联，请删除后重试"),
    RES_MAX_LEVEL_ERROR("0201016","资源组最大层级为%s"),
    ROLE_HAS_RES_ERROR("0201017","当前角色已绑定用户或组织，请删除后重试"),
    ROLE_MAX_LEVEL_ERROR("0201018","角色组最大层级为%s"),
    COMPANY_EXIST_USER("0201009","公司下存在用户，无法删除"),
    COMPANY_IMPORT_NOT_EXIST("0201010","导入的公司ID不存在"),
    TEAM_IMPORT_NOT_EXIST("0201011","导入的部门ID不存在"),
    TEAM_IMPORT_NOT_COMPANY_EXIST("0201012","导入的组织不属于填写的公司"),

    /**
     * 应用管理
     */
    /*应用管理*/
    APP_ID_IS_REPEAT("0301001","应用标识重复，请修改后再添加"),
    DICT_ID_IS_REPEAT("0301001","字典编码重复，请修改后再添加"),
    MEN_EXIST_CHILD("0301001","菜单存在子集，无法删除"),
    CONFIG_CODE_REPEAT_ERROR("0301002","该应用下已存在相同标识，请重新填写"),
    MEN_EXIST_AUTH("0301003","菜单已分配给用户、组织或群组，无法删除"),
    MEN_STATUS_NORMAL("0301004","只能删除停用的菜单"),
    APP_STATUS_NOT_DISABLE_ERROR("0301005","应用未停用，无法进行删除操作"),
    APP_HAS_MENU_ERROR("0301006","应用还存在菜单信息，无法进行删除操作"),
    APP_HAS_ROLE_ERROR("0301007","应用还存在角色信息，无法进行删除操作"),
    APP_MENU_NAME_EXIST_ERROR("0301008","相同层级下已存在相同名称菜单"),




    /*系统管理*/



    /*工作流*/
    FLOW_TYPE_EXIST_ERROR("0800001","工作流类别已存在"),
    FLOW_TYPE_CHILD_GROUP_EXIST_ERROR("0800002","工作流类别组只支持一级"),
    FLOW_TITLE_ERROR("0800001","流程标题(title)信息为空异常!"),
    FLOW_BUSINESS_ID_ERROR("0800002","请求业务Id为空异常!"),
    FLOW_NODE_NULL_ERROR("0800004","流程节点信息为空异常!"),
    FLOW_NODE_PERMISSION_NULL_ERROR("0800005","流程节点审批人信息为空异常!"),
    FLOW_EVENT_CONTENT_ERROR("0800006","事件信息缺失，缺少字段%s(%s)数据!"),
    FLOW_EXAMINE_PERMISSION_ERROR("0800007","没有该事件信息的审批权限!"),
    FLOW_EVENT_NULL_ERROR("0800008","事件信息为空异常!"),
    FLOW_RUN_EXAMINE_USER_ERROR("0800009","流程无法扭转，无下一处理人!"),
    FLOW_INFO_NULL_ERROR("0800010","流程信息不存在!"),
    FLOW_INFO_NAME_NULL_ERROR("0800011","流程名称:%s,节点信息不存在!"),
    FLOW_EVENT_CONTENT_JSON_ERROR("0800012","事件信息JSON数据异常!"),
    FLOW_COLUMNS_NULL_ERROR("0800013","流程字段配置信息不存在!"),
    FLOW_EXAMINE_USER_NOT_ERROR("0800014","该待办任务不属于当前用户审批!"),
    FLOW_VIEW_CHECK_USER_NOT_ERROR("0800015","该流程图任务(%s)审批用户未配置!"),
    FLOW_VIEW_NAME_NOT_ERROR("0800016","该流程图名称未填写!"),
    FLOW_VIEW_CODE_NOT_ERROR("0800017","该流程图编号未填写!"),
    FLOW_EXAMINE_NOT_DEAL_ERROR("0800018","该代办任务已处理或无需处理!"),
    FLOW_CALLBACK_NOT_METHOD_ERROR("0800019","未找到该审批流程的回调实例!"),
    FLOW_CALL_BACK_CONFIG_NULL_ERROR("0800020","流程回调配置信息未查询到!"),
    FLOW_TYPE_INFO_HAVE_ERROR("0800021","该流程类型的流程信息已存在!"),
    FLOW_TYPE_CHILDREN_EXIST_ERROR("0800022","工作流组下存在类别，请删除后重试"),
    FLOW_CALL_BACK_ERROR("0800023","流程回调执行异常! %s"),
    FLOW_EXCEL_IMPORT_ERROR("0800024","流程信息导入，表格格式不正确"),
    FLOW_START_BPM_CHECK_USER_ERROR("0800025","流程启动无固定人员未设置完全"),
    FLOW_TYPE_EXIST_FLOW_INFO_ERROR("0800026","类别正在被使用，请删除对应流程后重试");

    private String code;

    private String message;

    ErrorResultEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResultEnum setMessageObjs(Object... objs){
        this.message = String.format(this.message,objs);
        return this;
    }

    public Result getResult(){
        Result result = new Result();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(null);
        return result;
    }

    public void getError() throws Exception{
        throw new ResultException(this);
    }

}
