package br.com.zup.refund.model.to;

import br.com.zup.refund.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UserTO extends MainTO<UserTO, Employee>{
    private Long id;
    private String name;
    private String email;
}
