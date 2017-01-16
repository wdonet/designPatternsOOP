package ns.learning.patterns.adapter

import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult
import ns.learning.patterns.adapter.txnsystem.service.Service
import ns.learning.patterns.adapter.txnsystem.service.amex.AmexService
import ns.learning.patterns.adapter.txnsystem.service.banamex.BanamexService
import ns.learning.patterns.adapter.txnsystem.service.bancomer.BancomerService
import ns.learning.patterns.adapter.txnsystem.service.prosa.ProsaService

def services = [
        "BANAMEX" : new BanamexService(),
        "BANCOMER": new BancomerService(),
        "PROSA"   : new ProsaService(),
        "AMEX"    : new AmexService()
]

if (args.length < 1)
    throw new IllegalArgumentException("Missing service name")

if (!services.containsKey(args[0]))
    throw new IllegalArgumentException("Unsupported service")


Service service = services.get(args[0])

CardData cardData = new CardData()
double someAmount = 1000

TransactionResult txnResult = service.doSale(someAmount, cardData)

println txnResult.approvalCode