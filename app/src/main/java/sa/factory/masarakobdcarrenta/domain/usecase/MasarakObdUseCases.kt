package sa.factory.masarakobdcarrenta.domain.usecase

import sa.factory.masarakobdcarrenta.domain.repository.MasarakObdRepository
import sa.factory.masarakobdcarrenta.model.MasarakObdItem
import sa.factory.masarakobdcarrenta.model.MasarakObdOrder
import sa.factory.masarakobdcarrenta.model.MasarakObdTelemetry
import kotlinx.coroutines.flow.Flow

class GetCatalogUseCase(private val repository: MasarakObdRepository) {
    operator fun invoke(): Flow<List<MasarakObdItem>> = repository.catalogFlow
}

class ManageCartUseCase(private val repository: MasarakObdRepository) {
    val cart = repository.activeCart
    fun add(item: MasarakObdItem) = repository.addToCart(item)
    fun remove(item: MasarakObdItem) = repository.removeFromCart(item)
    fun clear() = repository.clearCart()
}

class ProcessCheckoutUseCase(private val repository: MasarakObdRepository) {
    suspend operator fun invoke(paymentMethod: String = "Mada Contactless EMV"): MasarakObdOrder =
        repository.checkout(paymentMethod)
}

class ObserveHardwareTelemetryUseCase(private val repository: MasarakObdRepository) {
    operator fun invoke(): Flow<MasarakObdTelemetry> = repository.telemetryFlow
}
