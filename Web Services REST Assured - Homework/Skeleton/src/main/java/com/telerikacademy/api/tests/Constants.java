package com.telerikacademy.api.tests;

public class Constants {
    public static final String BASE_URL = "https://trainingsoftuni1.atlassian.net";
    public static final String BASE_EMAIL = "krasenkochev89@gmail.com";
    public static final String ISSUE_URL ="/rest/api/latest/issue";
    public static final String API_TOKEN ="";
    public static final String BASE_PROJECT_KEY = "";
    public static final String ASSIGNEE = "Krasen Kochev";
    public static final String STORY = "Story";
    public static final String BUG = "Bug";
    public static final String SET_PRIORITY = "Highest";
    public static final String STORY_DESCRIPTION_TITLE = "*Change the language of the site to German*";

    public static final String STORY_DESCRIPTION_CONTENT = "As a German end User, I would like to see the site in my German language,\\n " +
            "so that I can navigate and use it effectively.";
    public static final String BUG_DESCRIPTION_TITLE ="Change the language of the site to German";
    public static final String BUG_DESCRIPTION_CONTENT = "*Summary:*\\n\\n" +
            "As a User, I want to change the language from English to German,\\n" +
            "*Steps to Reproduce:*\\n" +
            "Navigate to home page : https://www.phptravels.net/en\\n"+
            "Click on it.\\n"+
            "*Expected Result:*\\n"+
            "The User should be able to see the content of the page in German language.\\n"+
            "*Actual Result:*\\n"+
            "The User should be able to see the content of the page in German language, however the page stays in English language.";
    public static final String ENVIRONMENT = "Mozilla Firefox 2019 08 10 10 07 53\\n"+
            "OS - Windows 10 Pro N, 19044.2486 build, Windows Feature Experience Pack 120.2212.4190.0, Version - 21H2.";

    public static final String STORY_PAYLOAD ="{"
        + "\"fields\":{"
        + "\"project\":{\"key\":\"" + BASE_PROJECT_KEY +"\"},"
        + "\"summary\":\""+STORY_DESCRIPTION_TITLE+"\","
        + "\"description\":\""+STORY_DESCRIPTION_CONTENT+"\","
        + "\"issuetype\":{\"name\":\""+STORY+"\"},"
        + "\"priority\":{\"name\":\""+SET_PRIORITY+"\"},"
        + "\"assignee\":{\"name\":\"RM\"},"
        + "\"labels\":[\"UX\"],"
        + "\"components\":[{\"name\":\"Authentication\"}]"
        + "}}";

    public static final String BUG_PAYLOAD = "{"
            + "\"fields\":{"
            + "\"project\":{\"key\":\"" + BASE_PROJECT_KEY +"\"},"
            + "\"summary\":\""+BUG_DESCRIPTION_TITLE+"\","
            + "\"description\":\""+BUG_DESCRIPTION_CONTENT+"\","
            + "\"issuetype\":{\"name\":\""+BUG+"\"},"
            + "\"priority\":{\"name\":\""+SET_PRIORITY+"\"},"
            + "\"assignee\":{\"name\":\"RM\"},"
            + "\"labels\":[\"UX\", \"bug\"],"
            + "\"components\":[{\"name\":\"Authentication\"}]"
            + "}}";
}

