package nl.gemini.geminiapi.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TransactionInfoDto {

    private Double amount;

    private Boolean isSuccess;

    private String description;

    private Long accountId;
}
