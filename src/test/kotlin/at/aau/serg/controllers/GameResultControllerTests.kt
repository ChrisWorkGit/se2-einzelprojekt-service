package at.aau.serg.controllers

import at.aau.serg.models.GameResult
import at.aau.serg.services.GameResultService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when` as whenever
import kotlin.test.assertEquals

class GameResultControllerTests {

    private lateinit var mockedService: GameResultService
    private lateinit var controller: GameResultController

    @BeforeEach
    fun setup() {
        mockedService = mock(GameResultService::class.java)
        controller = GameResultController(mockedService)
    }

    @Test
    fun test_getGameResult_callsService() {
        val gr = GameResult(1, "Alice", 50, 30.0)
        whenever(mockedService.getGameResult(1)).thenReturn(gr)
        val result = controller.getGameResult(1)
        assertEquals(gr, result)
        verify(mockedService).getGameResult(1)
    }

    @Test
    fun test_getAllGameResults_callsService() {
        val list = listOf(GameResult(1, "Alice", 50, 30.0))
        whenever(mockedService.getGameResults()).thenReturn(list)
        val result = controller.getAllGameResults()
        assertEquals(list, result)
        verify(mockedService).getGameResults()
    }

    @Test
    fun test_addGameResult_callsService() {
        val gr = GameResult(0, "Alice", 50, 30.0)
        controller.addGameResult(gr)
        verify(mockedService).addGameResult(gr)
    }

    @Test
    fun test_deleteGameResult_callsService() {
        controller.deleteGameResult(1)
        verify(mockedService).deleteGameResult(1)
    }
}