package com.ajdacicjelena.storelocationapp.common.config;


public class AppConfig {

    /**
     * The default socket timeout in milliseconds
     */
    public static final int DEFAULT_TIMEOUT_MS = 3000;
    /**
     * The default number of retries
     */
    public static final int DEFAULT_MAX_RETRIES = 4;
    /**
     * The default backoff multiplier
     */
    public static final float DEFAULT_BACKOFF_MULT = 1f;
    /**
     * Shared Preferences key - locations list
     */
    public static final String LIST_STORAGE_KEY = "LOCATIONS_LIST";
    /**
     * Shared Preferences key - locations list
     */
    public static final String INTENT_STORE_EXTRA_KEY = "STORE";
}
