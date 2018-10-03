package com.leroiv.familyTree;


import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.repository.UserRepository;
import com.leroiv.familyTree.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {
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
