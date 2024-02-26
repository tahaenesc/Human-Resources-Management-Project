package org.group3.mapper;

import javax.annotation.processing.Generated;
import org.group3.dto.request.PaymentRequestDto;
import org.group3.dto.response.PaymentFindAllInfoResponseDto;
import org.group3.entity.Payment;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T22:22:12+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment requestDtoToManager(PaymentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Payment.PaymentBuilder payment = Payment.builder();

        payment.id( dto.getId() );
        payment.companyId( dto.getCompanyId() );
        payment.amount( dto.getAmount() );
        payment.dueDate( dto.getDueDate() );
        payment.description( dto.getDescription() );
        payment.type( dto.getType() );

        return payment.build();
    }

    @Override
    public PaymentFindAllInfoResponseDto paymentToPaymentFindAllInfoResponseDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentFindAllInfoResponseDto.PaymentFindAllInfoResponseDtoBuilder paymentFindAllInfoResponseDto = PaymentFindAllInfoResponseDto.builder();

        paymentFindAllInfoResponseDto.id( payment.getId() );

        return paymentFindAllInfoResponseDto.build();
    }
}
