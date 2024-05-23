

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class roles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "permisos", joinColumns = @JoinColumns(name = "rolId", inverseJoinColumns = @JoinColumns(name = "permisoId")))
    private set<permisos> permiso = new HashSet<>();

}