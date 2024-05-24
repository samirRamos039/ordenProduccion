


@userServices
public class UserDS implements UserDetailsService {
    
    @Autowired
    private userRepository userRepository;

    @Overrride
    public UserDatail loadUserByUsername(String username) throws UsernameNotFoundExeption{
        Optional <usuarios> users = userRepository.findByUsername(username);

        if(users.isPresent()){
           var userObj = users.get();
           return User.bulder()
                      .username(userObj.getUsername())
                      .password(userObj.getPassword())
                      .role(getRoles(userObj))
                      .build();
        } ekse {
            throw new UsernameNotFoundExeption(username)
        }

        private String[] getRole(usuarios users){
            if(users.getRole()== null){
                return new String[]{"USER"};
            }
            return users.getRole().split(",")
        }
    }
}