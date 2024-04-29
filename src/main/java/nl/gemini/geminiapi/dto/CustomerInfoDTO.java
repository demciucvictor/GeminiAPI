package nl.gemini.geminiapi.dto;

import lombok.Builder;
import lombok.Getter;
import nl.gemini.geminiapi.entity.Transaction;

import java.util.List;

@Builder
@Getter
public class CustomerInfoDTO {

    private String name;

    private String surname;

    private Double balance;

    private List<TransactionInfoDto> transactions;

}
