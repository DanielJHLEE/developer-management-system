package com.dev.developer_management_system.docs.swagger;

/**
 * 📘 Swagger Tags
 * 각 도메인(Controller)별 Swagger 그룹 및 API 설명 상수를 정의하는 클래스
 *
 * <p>컨트롤러의 @Tag(name, description) 또는
 * 메서드의 @Operation(summary, description)에 참조하여 사용합니다.</p>
 */
public final class SwaggerTags {

    private SwaggerTags() {} // 인스턴스화 방지

     /* ==========================================================
     * 👨‍💻 개발자 인력(TB_USER_MST) API
     * ========================================================== */
    public static final String USER_NAME = "👨‍💻 개발자 인력(TB_USER_MST) API";
    public static final String USER_DESC =
            "<b>개발자 인력 관리 API</b><br>" +
            "개발자 기본 정보 조회 기능을 제공합니다.<br>" +
            "개발자 목록 조회 및 개발자 번호(user_no) 기준 상세 조회 기능을 포함합니다.<br>" +
            "더미 데이터: <b>5개</b>";

    public static final String USER_GET_ALL_DESC = """
        👨‍💻 <b>개발자 인력 목록 조회</b><br>
        시스템에 등록된 모든 개발자 인력 정보를 조회합니다.<br>
        개발자 이름, 나이, 연락처, 등급, 주소, 성별 등의 정보를 포함합니다.<br>
        반환 형식: <code>List&lt;UserMstResponseDto&gt;</code>
        """;

    public static final String USER_GET_DETAIL_DESC = """
        🔍 <b>개발자 인력 상세 조회</b><br>
        개발자 번호(<code>user_no</code>)를 기준으로 단일 개발자 정보를 조회합니다.<br>
        존재하지 않는 개발자 번호일 경우 <code>404 Not Found</code> 또는 예외가 발생합니다.<br>
        반환 형식: <code>UserMstResponseDto</code>
        """;


    /* ==========================================================
     * 📦 투입 이력(TB_INPUT_HIST) API
     * ========================================================== */

    public static final String INPUT_HIST_NAME = "📦 투입 이력(TB_INPUT_HIST) API";
    public static final String INPUT_HIST_DESC =
            "<b>투입 이력 관리 API</b><br>" +
            "개발자 투입 이력을 조회하는 기능을 제공합니다.<br>" +
            "투입 이력 목록 조회 및 투입 이력 번호(input_hist_no) 기준 상세 조회 기능을 포함합니다.<br>" +
            "더미 데이터: <b>5개</b>";

}