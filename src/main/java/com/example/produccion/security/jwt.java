/* 
@Component
public class jwt{
   
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    public String generateToken(String username){
        return Jwts.builder()
             .setSubject(username)
             .setIssuedAt(new Date(System.currentTimeMilliis()))
             .setExpiration(new Date(System.currentTimeMilliis().Long.parseLong(timeExpiration)))
             .signWith(key getSignatureKey(),SignatureAlgoritms.HS256)
             .compact();

    }

    public boolean tokenValidate(String token){
        try{
            Jwts.parseBuilder()
            .setSignatureKey(getSignatureKey())
            .build()
            .parseClainJws(token)
            .getBody();
         return true;   

        }catch(Exeption e)
        log.error("token ivalid, error", concat(e.getMessage()))
         return false;
    }

    public Claims extractAllClaims(String token){
     return Jwts.parseBuilder()
            .setSignatureKey(getSignatureKey())
            .build()
            .parseClainJws(token)
            .getBody();
    }

    public String gerUserForToken(String token){
        return getClaims(token, Claims::getSubject);
    }

    public <T> T getClaims(String token, Function<Claims, T> claimsTFunctions){
        Claims claims = extractAllClaims();
        return claimsTFunctions.apply(claims)
    }

    public key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return keys.hmacShakeyFor(keyBytes);
    }
}*/