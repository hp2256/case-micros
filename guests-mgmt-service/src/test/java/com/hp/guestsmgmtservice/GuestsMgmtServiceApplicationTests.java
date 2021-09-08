package com.hp.guestsmgmtservice;

import com.hp.guestsmgmtservice.models.Address;
import com.hp.guestsmgmtservice.models.AllGuests;
import com.hp.guestsmgmtservice.models.Guest;
import com.hp.guestsmgmtservice.repos.GuestRepository;
import com.hp.guestsmgmtservice.services.GuestsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GuestsMgmtServiceApplicationTests {

    @InjectMocks
    private GuestsService guestsService;
    @Mock
    private GuestRepository guestRepository;

    @Test
    void testAddGuest() {
        Guest guest = new Guest(1, 122222222, "CG", "HP", "harsh@gmail.com", "male", new Address("street", 400000, "Mumb", "India"));
        when(guestsService.addGuest(guest)).thenReturn(guest);
        assertEquals(guest, guestRepository.save(guest));
    }
    @Test
    void testAll() {
        Guest guest = new Guest(1, 122222222, "CG", "HP", "harsh@gmail.com", "male", new Address("street", 400000, "Mumb", "India"));
        Guest guest2 = new Guest(1, 122222222, "CG", "HP", "harsh@gmail.com", "male", new Address("street", 400000, "Mumb", "India"));
        List<Guest> allGuests= new ArrayList<>(Arrays.asList(guest,guest2));
        when(guestsService.getAll()).thenReturn(allGuests);
        assertEquals(2, guestsService.getAll().size());
    }

    @Test
    void testFindOne() {

//        Optional<Guest> guest = Optional.of(new Guest(1, 122222222, "CG", "HP", "harsh@gmail.com", "male", new Address("street", 400000, "Mumb", "India")));
//        Guest guest1 = new Guest(1, 122222222, "CG", "HP", "harsh@gmail.com", "male", new Address("street", 400000, "Mumb", "India"));
//
//        guest.get().setId("1");
//       Mockito. when(guestsService.getGuest("1")).thenReturn(guest);
//        assertEquals(guest.get(), guestsService.getGuest("1"));
    }

    @Test
    void testUpdateOne() {
        Guest guest = new Guest(1, 122222222, "CG", "HP", "harsh@gmail.com", "male", new Address("street", 400000, "Mumb", "India"));
        when(guestsService.updateGuest(guest)).thenReturn(guest);
        assertEquals(guest,guestsService.updateGuest(guest));
    }
}
