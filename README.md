# Implémentation de Spring Security

## 1. Importation des dépendances

Assurez-vous d'importer les dépendances nécessaires dans votre fichier `pom.xml`.

## 2. Création de la classe JWTProvider

- Affectez les valeurs souhaitées à deux des quatre constantes (`JWT_SECRET`, `EXPIRES_AT`).
- Injectez la dépendance `UserDetailsService` (via le constructeur).
- Créez les quatre méthodes suivantes : `generateToken`, `validateToken`, `extractToken` et `createAuthentication`.

## 3. Implémentation de UserDetailsService

Mettez en œuvre la méthode `loadByUsername`.

## 4. Faites hériter User de UserDetails

- Ajoutez `extends UserDetails` à la classe User.
- Implémentez les méthodes en fonction de votre projet (`setRoles`, `enable`, `getPassword`, `getUsername`, ...).

## 5. Implémentation d'une méthode de login dans votre service

- Créez un `AuthDTO` qui contiendra le token, le login et les rôles.
- Créez un `LoginForm` qui contiendra le login et le mot de passe.
- Authentifiez l'utilisateur dans la méthode de login avec l'`authenticationManager`.
- Générez un token grâce à la méthode `generateToken` de votre `JWTprovider`.
- Renvoyez un `AuthDTO`.

## 6. Création d'un endpoint

Créez un endpoint pour appeler la méthode de login du service.

## 7. Création du JwtAuthenticationFilter

- Etendez la classe `OncePerRequestFilter`.
- Dans la méthode à implémenter, extrayez le token.
- Validez le token.
- Créez une `Authentication`.
- Passez à la suite des filtres.

## 8. Création de la SecurityConfig

- Implémentez la méthode `encode()` de `PasswordEncoder`.
- Implémentez `authenticationManager()`.
- Implémentez `securityFilterChain()`.
- Configurez l'accès aux endpoints.
- Annotez la classe avec `@EnableWebSecurity` et/ou `@EnableMethodSecurity`.

## 9. Sécurisation des méthodes

Si vous avez utilisé `@EnableMethodSecurity`, annotez les méthodes à sécuriser par `@PreAuthorize` et mettez en paramètre la restriction souhaitée.