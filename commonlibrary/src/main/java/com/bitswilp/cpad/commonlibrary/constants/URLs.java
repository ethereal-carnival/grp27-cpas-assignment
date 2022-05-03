package com.bitswilp.cpad.commonlibrary.constants;

public class URLs {
    public static final String HOST = "https://localhost";
    public static final int CORE_API_PORT = 8080;
    public static final int STATISTICS_PORT = 8081;
    public static final int BED_AVAILABILITY_PORT = 8082;
    public static final int NEARBY_HOSPITALS_PORT = 8083;
    public static final int WEBAPP_PORT = 8085;
    public static final int DATA_IMPORTER_PORT = 8088;
    public static final String URL_COMPONENT_GET = "get-";
    public static final String URL_COMPONENT_ADD = "add-";
    public static final String STATS = "statistics";
    public static final String BED_AVAILABILITY = "bed-availability";
    public static final String NEARBY_HOSPITALS = "nearby-hospitals";

    public static String getCoreApiUrl() {
        return urlConstructor(CORE_API_PORT);
    }

    public static String getStatsUrl() {
        return urlConstructor(STATISTICS_PORT);
    }

    public static String getBedsAvailabilityUrl() {
        return urlConstructor(BED_AVAILABILITY_PORT);
    }

    public static String getNearbyHospitalsUrl() {
        return urlConstructor(NEARBY_HOSPITALS_PORT);
    }

    private static String urlConstructor(int port) {
        return String.format("http://%s:%d/", HOST, port);
    }
}
