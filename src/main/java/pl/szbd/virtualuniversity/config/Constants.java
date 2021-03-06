package pl.szbd.virtualuniversity.config;

class Constants {
    static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    static final String SIGNING_KEY = "VirtualUniversity";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String AUTHORITIES_KEY = "scopes";
}
