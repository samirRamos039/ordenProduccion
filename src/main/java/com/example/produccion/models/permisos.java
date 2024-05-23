

@Entity
@Table(name = "permisos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class permisos{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String name;
}