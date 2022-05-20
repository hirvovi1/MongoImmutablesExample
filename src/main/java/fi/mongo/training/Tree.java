package fi.mongo.training;

import org.immutables.mongo.Mongo;
import org.immutables.value.Value;

@Value.Immutable
@Mongo.Repository
public abstract class Tree {

    @Mongo.Id
    public abstract long id();

    public abstract int height();

    public abstract TreeSpecies species();
}
