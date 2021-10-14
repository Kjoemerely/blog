package com.qk.blog.enums;

/**
 * @author qk
 * @since 2021/10/14 16:14
 */
public class CommonConstant {

    /**
     * 本应用ID
     */
    public static final String APP_ID = "CP_PLATFORM";

    /**
     * 本应用名称
     */
    public static final String APP_NAME = "产业互联云平台";

    /**
     * 系统配置redis获取key
     */
    public static final String APP_CONFIG = "PLATFORM_CONFIG";

    /**
     * 系统字典redis获取字典分组信息key
     */
    public static final String APP_DICT_GROUP = "PLATFORM_DICT_GROUP";

    /**
     * 系统字典redis获取所有字典信息key
     */
    public static final String APP_DICT_ALL = "PLATFORM_DICT_ALL";

    /**
     * 单位ID前缀
     */
    public static final String COMPANY_PREFIX = "C";

    /**
     * 组织ID前缀
     */
    public static final String TEAM_PREFIX = "T";

    /**
     * 用户ID前缀
     */
    public static final String USER_PREFIX = "U";

    /**
     * 状态值：正常
     */
    public static final String STATUS_NORMAL = "NORMAL";

    /**
     * 状态值：停用
     */
    public static final String STATUS_DISABLE = "DISABLE";

    /**
     * 状态值：删除
     */
    public static final String STATUS_DELETE = "DELETE";

    /**
     * 状态值：冻结/锁定
     */
    public static final String STATUS_LOCK = "LOCK";

    /**
     * token名称
     */
    public static final String DEFAULT_TOKEN_NAME = "Blog-Token";

    /**
     * header头请求应用ID
     */
    public static final String REQUEST_APP_ID = "Request-App-Id";

    /**
     * token名称
     */
    public static final String REQUEST_TOKEN_NAME = "Request-App-Token";
    
    /**
     * 操作成功
     */
    public static final String SUCCESS = "SUCCESS";

    /**
     * 操作失败
     */
    public static final String FAIL = "FAIL";

    /**
     * 是否开启Swagger
     */
    public static final boolean IF_OPEN_SWAGGER = true;

    /**
     * 根节点id
     */
    public static final String ROOT_NODE_ID = "#";


    /**
     * 是否允许多地登录
     */
    public static final boolean IF_MULTIPLE_LOGIN = false;


    /**
     * 注册默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";

}
