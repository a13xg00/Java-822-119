package bankObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Account {
    @Getter @Setter private static int id;
    @Getter @Setter private static double balance;
}
