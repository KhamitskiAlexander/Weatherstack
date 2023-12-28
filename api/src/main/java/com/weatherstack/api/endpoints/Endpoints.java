package io.automation.api.endpoints;

import io.automation.enums.Host;

public class Endpoints {

    private Endpoints() {
    }

    private static String baseUrl = System.getProperty("host"); // baseUrl = https://{env}.free2move.com
    public static String baseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(final Host host) {
        baseUrl = host.value();
    }

    public static final String LOGIN = "api/auth/login";
    public static final String VERIFICATION = "api/auth/otp/verify";
    public static final String MEDIA = "api/media";
    public static final String USER = "user/nimda/api/users";
    public static final String USER_ID = "user/nimda/api/users/{id}";
    public static final String USER_ROLES = "user/nimda/api/user-roles";
    public static final String ROLES = "nimda/api/roles";
    public static final String DRIVER_INFO = "user/nimda/api/user-driver-infos";
    public static final String DRIVER_INFO_ID = "user/nimda/api/user-driver-infos/{id}";
    public static final String DRIVER_INFO_ID_REFUSE = "user/nimda/api/user-driver-infos/{id}/refuse";
    public static final String SECRET_CODE = "user/api/me/otp";
    public static final String SUPPORTING_DOCUMENTS = "user/api/supporting-documents/";
    public static final String SIGNUP = "api/auth/sign-up";
    public static final String FORGOTTEN_PASSWORD = "api/auth/forgot-password";
    public static final String USER_ME = "user/api/me";
    public static final String USER_ME_GDPR_ACCEPT = "user/api/me/geoloc-accept";
    public static final String USER_CARDS = "user/api/cards";
    public static final String USER_CARDS_ID = "user/api/cards/{id}";
    public static final String DELETE_USER_ACCOUNT = "api/auth/revoke";
    public static final String SPOT_SEARCH_CDI = "/api/spots/place/CDG";
    public static final String SPOTS= "/api/spots/";
    public static final String SPOT_SEARCH_GEOCODE = "/api/spots/geocode";
    public static final String CARDS = "user/api/cards";
    public static final String PROXY_CONFIG = "api/pci-proxy/config";

    public static final String CAR = "rent/nimda/api/cars";
    public static final String CAR_ID = "rent/nimda/api/cars/{id}";
    public static final String CAR_ID_ACTION = "nimda/api/cars/{id}/{action}";
    public static final String PUT_CAR = "nimda/api/cars/{id}";

    public static final String RENT_AVAILABILITIES = "rent/nimda/api/rent-availabilities";

    public static final String RENTS = "rent/nimda/api/rents";
    public static final String RENTS_LILIGO = "rent/nimda/api/rent-liligo-feed-items";

    public static final String RENTS_OPTIONS = "rent/nimda/api/rent-options";
    public static final String GET_RENTS_OPTIONS = "rent/nimda/api/rent-options/{id}";
    public static final String PUT_RENTS_OPTIONS = "rent/nimda/api/rent-options/{id}";

    public static final String RENTS_SEARCH = "rent/nimda/api/rents/search";
    public static final String RENTS_ID = "rent/nimda/api/rents/{id}";
    public static final String RENTS_ID_CANCEL = "rent/nimda/api/rents/{id}/cancel";
    public static final String RENTS_ID_CHECK_IN = "rent/api/rents/{id}/check-in/complete";
    public static final String RENTS_ID_CHECK_OUT = "rent/api/rents/{id}/check-out/complete";
    public static final String RENTS_ID_DELETE_KEY = "nimda/api/rents/{id}/delete-car-key";
    public static final String GET_AVAILABILITIES = "nimda/api/rent-availabilities";
    public static final String UPDATE_RENT_PRICES = "rent/nimda/api/rents/{id}/update-prices";
    public static final String AVAILABLE_RENTS = "rent/api/rents/search?";
    public static final String RENT_SEARCH_META_BROKERS = "/rent/api/partners/{id}/feed-item/search";
    public static final String RENT_SELECT_META_BROKERS = "/rent/api/partners/{partner}/feed-item/{id}/select";

    public static final String RENT_UNAVAILABILITIES = "rent/nimda/api/rent-unavailabilities";
    public static final String GET_UNAVAILABILITIES = "rent/nimda/api/rent-unavailabilities";
    public static final String PUT_UNAVAILABILITY = "rent/nimda/api/rent-unavailabilities/{id}";

    public static final String STOP_SALES = "nimda/api/%s-stop-sells";
    public static final String AVAILABLE_STOP_SALES = "rent/nimda/api/%s-stop-sells";
    public static final String STOP_SALES_ID = "rent/nimda/api/%s-stop-sells/{id}";

    public static final String PARK_SEARCH = "/park/api/parks/search";
    public static final String PARK_STOP_SALES = "%s/nimda/api/stop-sells";
    public static final String PARK_AVAILABLE_STOP_SALES = "%s/nimda/api/stop-sells";
    public static final String PARK_STOP_SALES_ID = "%s/nimda/api/stop-sells/{id}";

    public static final String SITES_ID = "nimda/api/sites/{id}";

    public static final String PARK_ID = "park/nimda/api/{id}";

    public static final String RIDE_ID = "nimda/api/rides/{id}";

    public static final String CAR_LEASING = "rent/nimda/api/car-leasing";
    public static final String CARSHARING = "carsharing/nimda/api/carsharings/{id}";
    public static final String CARSHARINGS = "carsharing/api/cars";
    public static final String CARSHARING_FLEETS = "carsharing/api/fleets";
    public static final String INIT_CARSHARING = "carsharing/api/carsharings";
    public static final String CARSHARING_ID = "carsharing/api/carsharings/{id}";
    public static final String DEPOSIT_CARSHARING = "carsharing/api/carsharings/{id}/deposit?key={key}";

    public static final String BOOK_CARSHARING = "carsharing/api/carsharings/{id}/book?key={key}";
    public static final String PAY_CARSHARING = "carsharing/api/carsharings/{id}/pay?key={key}";
    public static final String START_CARSHARING = "carsharing/api/carsharings/{id}/start";
    public static final String PAUSE_CARSHARING = "carsharing/api/carsharings/{id}/pause?key={key}";
    public static final String RESUME_CARSHARING = "carsharing/api/carsharings/{id}/resume?key={key}";
    public static final String END_CARSHARING = "carsharing/api/carsharings/{id}/end";
    public static final String CANCEL_CARSHARING = "carsharing/api/carsharings/{id}/cancel";
    public static final String RATE_CARSHARING = "carsharing/api/carsharings/{id}/rate?key={key}";
    public static final String HIBERNATE_CARBOX = "carsharing/api/{id}/car/hibernate?key={key}";
    public static final String CARSHARING_PRICE_RULE = "carsharing/nimda/api/price-rules/{id}";
    public static final String CARSHARING_INVOICE = "/carsharing/api/carsharings/{id}/invoices?key={key}";
    public static String CS_PARK_POI = "carsharing/nimda/api/pois";
    public static String CS_PARK_POI_ID = "carsharing/nimda/api/pois/{id}";
    public static final String CARSHARING_COUPONS = "carsharing/nimda/api/coupons";
    public static final String CARSHARING_COUPONS_ID = "carsharing/nimda/api/coupons/{id}";
    public static final String USER_CARSHARING_COUPONS = "nimda/api/user-carsharing-coupons";

    public static final String CARSHARING_INVOICE_ITEMS = "/carsharing/api/vulog/fleets/{fleetId}/{items}/csv";
    public static final String SHARE_NOW_PATH = "https://partner.int.share-now.com/";
    public static final String RENT_COUPONS = "rent/nimda/api/rent-coupons";
    public static final String RENT_COUPONS_ID = "rent/nimda/api/rent-coupons/{id}";
    public static final String USER_RENT_COUPONS = "nimda/api/user-rent-coupons";
    public static final String PARK_COUPONS = "park/nimda/api/coupons";
    public static final String PARK_COUPONS_ID = "park/nimda/api/coupons/{id}";
    public static final String USER_PARK_COUPONS = "nimda/api/user-park-coupons";
    public static final String RIDE_COUPONS = "ride/nimda/api/coupons";
    public static final String RIDE_COUPONS_ID = "ride/nimda/api/coupons/{id}";
    public static final String USER_RIDE_COUPONS = "nimda/api/user-ride-coupons";

    public static final String OFFERS = "smart/api/offers";
    public static final String CONTRACTS = "/smart/api/contracts/{id}";
    public static final String CONTRACTS_SEARCH = "smart/api/contracts/search";
    public static final String CONTRACTS_SUBMIT = "smart/api/contracts/{id}/submit";
    public static final String CONTRACTS_PAY = "smart/api/contracts/{id}/pay";
    public static final String CONTRACTS_CANCEL = "smart/api/contracts/{id}/cancel";

    public static final String INVOICE_RECOVER = "nimda/api/invoices/{id}/recover";
    public static final String INVOICE_CLOSE = "nimda/api/invoices/{id}/mark-as-closed";
    public static final String INVOICE_OPEN = "nimda/api/invoices/{id}/open";
    public static final String INVOICES = "nimda/api/invoices";
    public static final String GET_INVOICE = "nimda/api/invoices/{id}";
    public static final String CREATE_INVOICE_FOR_RENT = "rent/nimda/api/rents/{id}/create-invoice";
    public static final String GET_INVOICES_BY_RENT_ID = "rent/nimda/api/rent-invoices/{id}/invoices";

    public static final String ADD_PRIZES_FOR_WHEEL_OF_FORTUNE = "nimda/api/prizes";

    public static final String EMAIL_CONFIRMATION_GET_KEY = "nimda/api/users/{id}/request-email-confirmation";
    public static final String EMAIL_CONFIRMATION_VALIDATE = "api/auth/confirm-email/{id}?key={key}";

    public static final String COD_CUSTOMER = "cod/nimda/api/cod-customers";
    public static final String COD_CUSTOMER_COMPLETE = "cod/nimda/api/cod-customers/{id}/complete";
    public static final String COD_PUT_CUSTOMER = "cod/nimda/api/cod-customers/{id}";
    public static final String COD_CONTRACTS = "cod/nimda/api/cod-contracts-v2/{id}";
    public static final String COD_CREATE_CONTRACTS = "cod/nimda/api/cod-contracts-v2";
    public static final String COD_CONTRACTS_STATUS = "cod/nimda/api/cod-contracts-v2/{id}/{status}";
    public static final String COD_DELIVERIES_LIST = "cod/nimda/api/cod-deliveries";
    public static final String COD_DELIVERIES = "cod/nimda/api/cod-deliveries/{id}";
    public static final String COD_CREATE_OFFERS = "cod/nimda/api/cod-offers";
    public static final String COD_OFFERS = "cod/nimda/api/cod-offers/{id}";
    public static final String COD_CREATE_PRICES = "cod/nimda/api/cod-prices";
    public static final String COD_PRICES = "cod/nimda/api/cod-prices/{id}";
    public static final String COD_CREATE_INSURANCE = "cod/nimda/api/cod-insurances";
    public static final String COD_VLM_STATUS = "cod/nimda/api/vlm/{vin}";
    public static final String COD_POST_ORDER = "cod/api/orders";
    public static final String COD_GET_ORDER_DETAILS = "cod/api/orders/{id}";
    public static final String COD_PUT_ORDER_CONTRACT = "cod/api/orders/{id}/contract";
    public static final String COD_ELIGIBILITY = "cod/api/fleets/{id}/eligibility";
    public static final String COD_FLEET_DETAILS = "cod/api/fleets/{id}";
    public static final String COD_INSURANCE_DETAILS = "cod/api/offers/{id}/insurances";
    public static final String COD_PRICE_BY_COMMITMENT = "cod/api/offers/{id}/prices/by-commitment";
    public static final String COD_PRICE_DETAILS = "cod/api/offers/{id}/prices";
    public static final String COD_OPTION_DETAILS = "cod/api/offers/{id}/options";

    public static final String TICKETS = "rent/nimda/api/tickets";

    public static final String INSURANCE_CONTRACT = "rent/nimda/api/insurance-contracts";
    public static final String PUT_INSURANCE_CONTRACT = "rent/nimda/api/insurance-contracts/{id}";

    public static final String SUPPORT_CASE = "nimda/api/support-cases";
    public static final String PUT_SUPPORT_CASE = "nimda/api/support-cases/{id}";

    public static final String ORCHESTRA_OFFERS = "park/nimda/api/orchestra-offers";
    public static final String GET_ORCHESTRA_OFFERS = "park/nimda/api/orchestra-offers/{id}";
    public static final String PUT_ORCHESTRA_OFFERS = "park/nimda/api/orchestra-offers/{id}";

    public static final String INSURANCE = "rent/nimda/api/insurances";
    public static final String GET_INSURANCE = "rent/nimda/api/insurances/{id}";
    public static final String PUT_INSURANCE = "rent/nimda/api/insurances/{id}";

    public static final String INSURANCE_OPTION = "rent/nimda/api/insurance-options";
    public static final String GET_INSURANCE_OPTION = "rent/nimda/api/insurance-options/{id}";
    public static final String PUT_INSURANCE_OPTION = "rent/nimda/api/insurance-options/{id}";

    public static final String AFFILIATE = "nimda/api/affiliates";
    public static final String GET_AFFILIATE = "nimda/api/affiliates/{id}";
    public static final String PUT_AFFILIATE = "nimda/api/affiliates/{id}";

    public static final String AFFILIATES_RENT = "rent/nimda/api/rent-affiliates";
    public static final String GET_AFFILIATES_RENT = "rent/nimda/api/rent-affiliates/{id}";
    public static final String PUT_AFFILIATES_RENT = "rent/nimda/api/rent-affiliates/{id}";

    public static final String COMPANIES = "nimda/api/companies";

    public static final String INSPECTION_REPORTS = "rent/nimda/api/checks";
    public static final String GET_INSPECTION_REPORTS = "rent/nimda/api/checks";
    public static final String CANCEL_INSPECTION_REPORT = "rent/nimda/api/checks/{id}/cancel";

    public static final String MARKET = "rent/nimda/api/rent-country-groups";
    public static final String GET_MARKET = "rent/nimda/api/rent-country-groups/{id}";
    public static final String PUT_MARKET = "rent/nimda/api/rent-country-groups/{id}";

    public static final String GET_PARTNER_RENTS_SEARCH = "rent/api/partners/free2move/search";

    public static final String CAR_MODEL = "rent/nimda/api/car-models";
    public static final String GET_CAR_MODEL = "rent/nimda/api/car-models/{id}";
    public static final String PUT_CAR_MODEL = "rent/nimda/api/car-models/{id}";

    public static final String USER_POLICIES = "user/nimda/api/user-policies/{id}";
    public static final String GET_USER_POLICES = "user/nimda/api/user-policies";
    public static final String PUT_USER_POLICE = "user/nimda/api/user-policies/{id}";

    public static final String RESACAR_BOOKING = "/rent/api/resacar";
    public static final String IMA_BOOKING = "/rent/api/ima";

    public static final String AGENCY = "rent/nimda/api/rent-agencies";
    public static final String PUT_AGENCY = "rent/nimda/api/rent-agencies/{id}";
    public static final String GET_AGENCY = "rent/nimda/api/rent-agencies/{id}";

    public static final String RESACAR_AGENCIES = "rent/api/resacar/agencies";
}