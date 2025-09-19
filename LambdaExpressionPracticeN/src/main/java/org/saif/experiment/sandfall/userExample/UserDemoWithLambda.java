package org.saif.experiment.sandfall.userExample;

import java.util.Comparator;

public class UserDemoWithLambda {

    public static final Comparator<User> BY_NAME = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());

//    public static final Comparator<User> BY_ID_DESC = (o1, o2) ->  Integer.compare(o2.getId(), o1.getId());
    public static final Comparator<User> BY_ID_DESC = Comparator.comparing(User::getId).reversed();


    /* 3. Lambda chained with thenComparing */
    public static final Comparator<User> BY_AGE_THEN_NAME =
                        Comparator.comparing(User::getAge)
                                .thenComparing(User::getName);
}
