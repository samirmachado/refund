package br.com.zup.refund.model.to;

import br.com.zup.refund.model.User;
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
public class UserWithoutEmailTO extends MainTO<UserWithoutEmailTO, User> {
    private Long id;
    private String name;
}
