package pl.laptopy.polizingowe.config;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
public class WebSecurityConfig  {

//    private PropertiesConfig propertiesConfig;
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().ignoringAntMatchers("/h2-console/**").disable()
//                .headers().frameOptions().disable()
//                .and().authorizeRequests().antMatchers("/stefan/**").permitAll()
//                .and().authorizeRequests().antMatchers("/admin/**").permitAll()
//                .and().authorizeRequests().antMatchers("/", "/home").permitAll()
//                .and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username(propertiesConfig.getSecurityUsername())
//                        .password(propertiesConfig.getSecurityPassword())
//                        .roles(Roles.ADMIN.name())
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
