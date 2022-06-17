package marqui.matheus.marquifood.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class Problem {
    private Integer status;
    private String type;
    private String title;
    private String detail;

}
