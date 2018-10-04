package com.leroiv.familyTree;


public class PersonServiceTest {
    /*@Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository,
                mockRoleRepository,
                mockBCryptPasswordEncoder);
        user = User.builder()
                .userName("ion")
                .password("Ponce")
                .build();

        Mockito.when(mockUserRepository.save(user))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findUserByUserName("ion"))
                .thenReturn(user);
    }


    @Test
    public void testSaveUser() {
        // Setup
        final String username = "ion";

        // Run the test
        User result = userServiceUnderTest.saveOrUpdate(User.builder().build());

        // Verify the results
        assertEquals(username, result.getUserName());
    }

    @Test
    public void testFindUserByUserName() {
        // Setup
        final String username = "ion";

        // Run the test
        final User result = userServiceUnderTest.findUserByUserName(username);

        // Verify the results
        assertEquals(username, result.getUserName());
    }*/
}
