package com.example.tickets.Screens.ListofMovies

import com.example.tickets.BaseViewModel
import com.example.tickets.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(val moviesRepository: MoviesRepository ) : BaseViewModel<HomeUIState>(HomeUIState()),
    HomeScreenInteractions {
    override fun updateHomeContent(selectedContent: HomeContentType) {
        _state.update {
            it.copy(
                homeContentType = selectedContent, movies = when (selectedContent) {
                    HomeContentType.ComingSoon -> moviesRepository.getComingSoonMovies()
                    HomeContentType.NowShowing -> moviesRepository.getNowShowingMovies()
                }
            )
        }
    }


    init {
        _state.update {
            it.copy(
                moviesRepository.getNowShowingMovies()
            )
        }
    }
}