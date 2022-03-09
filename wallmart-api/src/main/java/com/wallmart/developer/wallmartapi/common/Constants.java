package com.wallmart.developer.wallmartapi.common;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public class Constants {

	public static final String ENDPOINT = "/wallmart";

	public static final String VERSION = ENDPOINT + "/v1";

	public static final String END_REQUEST = VERSION + "/product";

	public static final String SEARCH_BY_PRODUCT = "/search";

	public static final String DEFAULT_PAGE = "0";

	public static final String DEFAULT_SIZE = "10";

	public static final String DEFAULT_ORDER = "id";

	public static final String DEFAULT_ASC = "true";

	private Constants() {
		throw new IllegalAccessError();
	}

}
