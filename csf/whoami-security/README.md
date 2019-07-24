Website:
https://www.callicoder.com/spring-boot-security-oauth2-social-login-part-1/


OAuth2 Login Flow
The OAuth2 login flow will be initiated by the frontend client by sending the user to the endpoint http://localhost:8080/oauth2/authorize/{provider}?redirect_uri=<redirect_uri_after_login>.

The provider path parameter is one of google, facebook, or github. The redirect_uri is the URI to which the user will be redirected once the authentication with the OAuth2 provider is successful. This is different from the OAuth2 redirectUri.

On receiving the authorization request, Spring Security’s OAuth2 client will redirect the user to the AuthorizationUrl of the supplied provider.

All the state related to the authorization request is saved using the authorizationRequestRepository specified in the SecurityConfig.

The user now allows/denies permission to your app on the provider’s page. If the user allows permission to the app, the provider will redirect the user to the callback url http://localhost:8080/oauth2/callback/{provider} with an authorization code. If the user denies the permission, he will be redirected to the same callbackUrl but with an error.

If the OAuth2 callback results in an error, Spring security will invoke the oAuth2AuthenticationFailureHandler specified in the above SecurityConfig.

If the OAuth2 callback is successful and it contains the authorization code, Spring Security will exchange the authorization_code for an access_token and invoke the customOAuth2UserService specified in the above SecurityConfig.

The customOAuth2UserService retrieves the details of the authenticated user and creates a new entry in the database or updates the existing entry with the same email.

Finally, the oAuth2AuthenticationSuccessHandler is invoked. It creates a JWT authentication token for the user and sends the user to the redirect_uri along with the JWT token in a query string.