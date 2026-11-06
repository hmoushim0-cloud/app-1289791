package sa.factory.masarakobdcarrenta.data.remote

import sa.factory.masarakobdcarrenta.model.MasarakObdItem
import sa.factory.masarakobdcarrenta.model.MasarakObdOrder

interface MasarakObdApiService {
    suspend fun fetchCatalog(): List<MasarakObdItem>
    suspend fun submitOrder(order: MasarakObdOrder): Boolean
}
