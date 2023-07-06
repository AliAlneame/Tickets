package com.example.tickets.Screens.Booking

import com.example.tickets.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(): BaseViewModel<BookingUIState>(BookingUIState()) {

    private val dateItems = listOf(
        DateUIState("17", "Sun"),
        DateUIState("18", "Mon"),
        DateUIState("19", "Tues"),
        DateUIState("20", "Wed"),
        DateUIState("21", "Thurs"),
        DateUIState("22", "Fri"),
        DateUIState("23", "Sat"),

        )
    private val timeItems = listOf("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00")

    init {
        _state.update {
            it.copy(
                bookingDateItems = dateItems,
                timeItems = timeItems,
                price = 100.00,
                availableTickets = 4
            )
        }
    }

}