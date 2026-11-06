package sa.factory.masarakobdcarrenta.di

import sa.factory.masarakobdcarrenta.data.repository.MasarakObdRepositoryImpl
import sa.factory.masarakobdcarrenta.domain.repository.MasarakObdRepository
import sa.factory.masarakobdcarrenta.domain.usecase.*
import sa.factory.masarakobdcarrenta.hardware.HardwareSensorDriver
import sa.factory.masarakobdcarrenta.ui.viewmodel.MasarakObdViewModel

class DiContainer {
    val sensorDriver = HardwareSensorDriver()
    val repository: MasarakObdRepository = MasarakObdRepositoryImpl(sensorDriver)

    val getCatalogUseCase = GetCatalogUseCase(repository)
    val manageCartUseCase = ManageCartUseCase(repository)
    val processCheckoutUseCase = ProcessCheckoutUseCase(repository)
    val observeHardwareTelemetryUseCase = ObserveHardwareTelemetryUseCase(repository)

    fun provideViewModel(): MasarakObdViewModel = MasarakObdViewModel(
        getCatalogUseCase,
        manageCartUseCase,
        processCheckoutUseCase,
        observeHardwareTelemetryUseCase
    )
}
