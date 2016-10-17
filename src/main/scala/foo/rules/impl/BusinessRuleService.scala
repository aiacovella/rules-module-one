package foo.rules.impl

import com.foo.rules.spi._
import com.pathfinder.wire.read.domain.model.OutgoingWire
import java.time._
import scala.collection.immutable.Seq

/**
  * Implementation of a business rules service.
  */
class BusinessRuleService extends BusinessRulesProviderT {

  override def rules: Seq[BusinessRuleT] = Seq(new AmountGreaterThanRule())

  override def version: String = "1.0.0"

  override def releaseDate: LocalDate = OffsetDateTime.of(2016, 10, 4, 0, 0, 0, 0, ZoneOffset.UTC).toLocalDate

}



class AmountGreaterThanRule extends BusinessRuleT {

  override def description: String = "Validates that a wire amount is not more than one thousand dollars."

  override def shortName: String = "Wire Less Than Or Equal To One Thousand"

  override def execute(wire: OutgoingWire): BusinessExceptionStatus = {

    if (wire.amount <= 1000) {
      ExceptionSuccess()
    }
    else {
      ExceptionFailure(Some("The wire amount must be less than or equal to 1000"))
    }
  }

}
