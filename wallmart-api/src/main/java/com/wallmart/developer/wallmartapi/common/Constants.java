package com.wallmart.developer.wallmartapi.common;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public class Constants {

	public static final String ENDPOINT = "/wallmart";

	public static final String VERSION = ENDPOINT + "/v1";

	public static final String END_REQUEST = VERSION + "/product";

	public static final String SEARCH = "/search";

	public static final String SEARCH_BY_ID = "/searchid";

	public static final String SEARCH_BY_BRAND = "/searchbrand";

	public static final String SEARCH_BY_PRODUCT = "/search";

	public static final String SEARCH_ALL = "/searchall";

	public static final String SAVE = "/save";

	public static final String INSERT = "/insert";

	public static final String UPDATE = "/update";

	public static final String DELETE = "/delete";

	public static final String SUCCESS_SAVE = "Producto guardado correctamente.";

	public static final String SUCCESS_DELETE = "Producto eliminado correctamente.";

	public static final String DEFAULT_PAGE = "0";

	public static final String DEFAULT_SIZE = "10";

	public static final String DEFAULT_ORDER = "id";

	public static final String DEFAULT_ASC = "true";

	/**
     * Default DATE TIME FORMAT
     * 
     */
    public static final String DATE_TIME_FORMAT = "dd-MM-yyyy";

	private Constants() {
		throw new IllegalAccessError();
	}

}
