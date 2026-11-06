package sa.factory.masarakobdcarrenta.domain.repository

import sa.factory.masarakobdcarrenta.model.MasarakObdItem
import sa.factory.masarakobdcarrenta.model.MasarakObdOrder
import sa.factory.masarakobdcarrenta.model.MasarakObdTelemetry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MasarakObdRepository {
    val catalogFlow: Flow<List<MasarakObdItem>>
    val activeCart: StateFlow<List<MasarakObdItem>>
    val telemetryFlow: Flow<MasarakObdTelemetry>
    
    fun addToCart(item: MasarakObdItem)
    fun removeFromCart(item: MasarakObdItem)
    fun clearCart()
    suspend fun checkout(paymentMethod: String): MasarakObdOrder
    suspend fun refreshCatalog()
}
