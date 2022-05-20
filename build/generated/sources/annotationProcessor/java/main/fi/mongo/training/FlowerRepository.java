package fi.mongo.training;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import org.bson.codecs.Encoder;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.immutables.mongo.concurrent.FluentFuture;
import org.immutables.mongo.repository.Repositories;
import org.immutables.mongo.repository.RepositorySetup;
import org.immutables.mongo.repository.internal.Constraints;
import org.immutables.mongo.repository.internal.Support;
import org.immutables.value.Generated;

/**
 * A {@code FlowerRepository} provides type-safe access for storing and retrieving documents
 * from the MongoDB collection {@code "flower"}.
 */
@Generated(from = "Flower", generator = "Repositories")
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@ThreadSafe
public class FlowerRepository extends Repositories.Repository<Flower> {
  private static final String DOCUMENT_COLLECTION_NAME = "flower";

  private final Serialization serialization;
  private final Criteria anyCriteria;

  /**
   * Constructs a {@link Flower} repository using {@link RepositorySetup configuration}.
   * @param configuration The repository configuration
   */
  public FlowerRepository(RepositorySetup configuration) {
    super(configuration, DOCUMENT_COLLECTION_NAME, Flower.class);
    this.serialization = new Serialization(codecRegistry(), fieldNamingStrategy());
    this.anyCriteria = new Criteria(this.serialization, Constraints.nilConstraint());
  }

  /**
   * Inserts a single document into the collection.
   * @param document The flower to insert
   * @return A future representing the number of inserted documents (1) if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> insert(Flower document) {
    return super.doInsert(ImmutableList.of(document));
  }

  /**
   * Insert documents into the collection.
   * @param documents The documents to insert
   * @return A future representing the number of inserted documents if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> insert(Iterable<? extends Flower> documents) {
    return super.doInsert(ImmutableList.copyOf(documents));
  }

  /**
   * Finds all documents. Use the returned {@link Finder} object to complete
   * {@link Finder#fetchAll() fetch all} or other operations.
   * @return A finder object used to complete operations
   */
  @CheckReturnValue
  public Finder findAll() {
    return find(criteria());
  }

  /**
   * Find documents by the criteria expressed as a JSON string. Use the returned {@link Finder} object to complete
   * {@link Finder#fetchAll() fetch} or {@link Finder#fetchFirst() fetch} operations.
   * @param jsonCriteria A JSON string for native criteria
   * @return A finder object used to complete operations
   */
  @CheckReturnValue
  public Finder find(String jsonCriteria) {
    return new Finder(this, Support.jsonQuery(jsonCriteria));
  }

  /**
   * Find documents by the {@link Flower#getId() id} identity attribute. Use the returned {@link Finder} object to complete
   * {@link Finder#fetchFirst() fetch} or {@link Finder#fetchAll() fetchAll} read operations.
   * You can also use {@link Finder#andModifyFirst() modify}, {@link Finder#andReplaceFirst(Flower) replace}
   * or {@link Finder#deleteFirst() delete} operations to update / delete the document.
   * @param id The exact {@code id} value
   * @return A finder object used to complete operations
   */
  @CheckReturnValue
  public Finder findById(ObjectId id) {
    return find(criteria().id(id));
  }

  /**
   * Update or insert a document, matched by the identifier value of the 'id' attribute.
   * @param document The flower to upsert
   * @return A future representing the of number of inserted documents (1) if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> upsert(Flower document) {
    Criteria byId = criteria().id(document.getId());
    return super.doUpsert(byId.constraint, document);
  }

  /**
   * Find a document by the given {@link FlowerRepository#criteria() criteria}. Use the returned {@link Finder} object to complete
   * {@link Finder#fetchAll() fetch}  operations.
   * You can also use {@link Finder#andModifyFirst() modify} or {@link Finder#deleteFirst() delete}
   * operations to update / delete the document(s).
   * @param criteria The search criteria
   * @return A finder object used to complete operations
   */
  @CheckReturnValue
  public Finder find(Criteria criteria) {
    return new Finder(this, criteria.constraint);
  }

  /**
   * The finder object used to proceed with find operations via the
   * {@link Finder#fetchAll()}, {@link Finder#fetchFirst()}, {@link Finder#andModifyFirst()}, or {@link Finder#deleteFirst()} methods.
   * Configure exclusion and sort ordering for results using the family of {@code exclude*()} and {@code orderBy*()} attribute-specific methods.
   * @see FlowerRepository#find(Criteria)
   */
  @Generated(from = "Flower", generator = "Repositories")
  @NotThreadSafe
  public static final class Finder extends Repositories.FinderWithDelete<Flower, Finder> {
    private final Serialization serialization;

    private Finder(FlowerRepository repository, Constraints.ConstraintHost criteria) {
      super(repository);
      this.criteria = criteria;
      this.serialization = repository.serialization;
    }

    /**
     * Order by {@link Flower#getId() id} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getId() id} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderById() {
      ordering = ordering.equal(serialization.idName, false, 1);
      return this;
    }

    /**
     * Order by {@link Flower#getId() id} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getId() id} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByIdDesceding() {
      ordering = ordering.equal(serialization.idName, false, -1);
      return this;
    }

    /**
     * Order by {@link Flower#getName() name} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getName() name} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByName() {
      ordering = ordering.equal(serialization.nameName, false, 1);
      return this;
    }

    /**
     * Order by {@link Flower#getName() name} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getName() name} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByNameDesceding() {
      ordering = ordering.equal(serialization.nameName, false, -1);
      return this;
    }

    /**
     * Order by {@link Flower#getIsBlooming() isBlooming} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getIsBlooming() isBlooming} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByIsBlooming() {
      ordering = ordering.equal(serialization.isBloomingName, false, 1);
      return this;
    }

    /**
     * Order by {@link Flower#getIsBlooming() isBlooming} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getIsBlooming() isBlooming} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByIsBloomingDesceding() {
      ordering = ordering.equal(serialization.isBloomingName, false, -1);
      return this;
    }

    /**
     * Order by {@link Flower#getHeight() height} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getHeight() height} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByHeight() {
      ordering = ordering.equal(serialization.heightName, false, 1);
      return this;
    }

    /**
     * Order by {@link Flower#getHeight() height} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getHeight() height} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByHeightDesceding() {
      ordering = ordering.equal(serialization.heightName, false, -1);
      return this;
    }

    /**
     * Order by {@link Flower#getColors() colors} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getColors() colors} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByColors() {
      ordering = ordering.equal(serialization.colorsName, false, 1);
      return this;
    }

    /**
     * Order by {@link Flower#getColors() colors} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Flower#getColors() colors} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByColorsDesceding() {
      ordering = ordering.equal(serialization.colorsName, false, -1);
      return this;
    }

    /**
     * Exclude the {@link Flower#getColors() colors} attribute from each document in the results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder excludeColors() {
      exclusion = exclusion.equal(serialization.colorsName, false, -1);
      return this;
    }

    /**
     * Turn a find operation into an atomic {@link DBCollection#findAndModify(DBObject, DBObject, DBObject, boolean, DBObject, boolean, boolean) findAndModify}
     * operation. Use the family of {@code set*()}, {@code unset*()}, {@code add*()}, {@code remove*()}, {@code put*()}m and {@code init*()}
     * (and other attribute-specific) methods to describe the modification.
     * @return A modifier object to complete the {@code findAndModify} operation
     */
    @CheckReturnValue
    public Modifier andModifyFirst() {
      return new Modifier((FlowerRepository) repository, criteria, ordering, exclusion);
    }

    /**
     * Used to replace in-place existing version of the document
     */
    @CheckReturnValue
    public Replacer andReplaceFirst(Flower document) {
      return new Replacer((FlowerRepository) repository, document, criteria, ordering);
    }
  }

  /**
   * Update the set of {@code "flower"} documents.
   * @param criteria The search criteria for update
   * @return An updater object that will be used to complete the update.
   */
  @CheckReturnValue
  public Updater update(Criteria criteria) {
    return new Updater(this, criteria);
  }

  /**
   * {@link #update(Criteria) Given} the criteria updater describes how to perform
   * update operations on sets of documents.
   */
  @Generated(from = "Flower", generator = "Repositories")
  @NotThreadSafe
  public static final class Updater extends Repositories.Updater<Flower> {
    private final Serialization serialization;

    private Updater(FlowerRepository repository, Criteria criteria) {
      super(repository);
      this.criteria = criteria.constraint;
      this.serialization = repository.serialization;
    }

    /**
     * Specify a new value for the {@code id} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code id} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setId(ObjectId value) {
      setFields = setFields.equal(serialization.idName, false, Support.writable(serialization.idEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code id} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code id} value for an insert.
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater initId(ObjectId value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.idName, false, Support.writable(serialization.idEncoder, value));
      return this;
    }


    /**
     * Specify a new value for the {@code name} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code name} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setName(java.lang.String value) {
      setFields = setFields.equal(serialization.nameName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an initial value for the {@code name} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code name} value for an insert.
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater initName(java.lang.String value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.nameName, false, Support.writable(value));
      return this;
    }


    /**
     * Specify a new value for the {@code isBlooming} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code isBlooming} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setIsBlooming(Boolean value) {
      setFields = setFields.equal(serialization.isBloomingName, false, Support.writable(serialization.isBloomingEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code isBlooming} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code isBlooming} value for an insert.
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater initIsBlooming(Boolean value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.isBloomingName, false, Support.writable(serialization.isBloomingEncoder, value));
      return this;
    }


    /**
     * Specify a new value for the {@code height} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code height} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setHeight(Float value) {
      setFields = setFields.equal(serialization.heightName, false, Support.writable(serialization.heightEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code height} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code height} value for an insert.
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater initHeight(Float value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.heightName, false, Support.writable(serialization.heightEncoder, value));
      return this;
    }


    /**
     * Clear the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator resetting to empty array
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater clearColors() {
      setFields = setFields.equal(serialization.colorsName, false, ImmutableList.<Object>of());
      return this;
    }

    /**
     * Remove a value from the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $pull} operator.
     * @param value The value to remove
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater removeColors(java.lang.String value) {
      pullFields = pullFields.equal(serialization.colorsName, false, Support.writable(value));
      return this;
    }

    /**
     * Add a value to the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $push} operator.
     * @param value The value to add
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater addColors(java.lang.String value) {
      pushFields = pushFields.equal(serialization.colorsName, false, Support.writable(value));
      return this;
    }

    /**
     * Override all values of {@code colors} list attribute.
     *
     * <p>Corresponds to the MongoDB {@code $set} operator on the array field.
     * @param values The values to set
     * @return {@code this} updater to be used to complete the update operation
     */
     public Updater setColors(Iterable<java.lang.String> values) {
       List<Object> wrappedValues = new ArrayList<>();
       for (java.lang.String value : values) {
         wrappedValues.add(Support.writable(value));
       }

       setFields = setFields.equal(serialization.colorsName, false, wrappedValues);
       return this;
     }

    /**
     * Add all of the given values to the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $push} operator with the {@code $each} modifier.
     * @param values The values to add
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater addAllColors(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      if (wrappedValues.isEmpty()) {
        return this;
      }
      Object v = wrappedValues.size() == 1
          ? wrappedValues.get(0)
          : Support.bsonObjectAttribute("$each", wrappedValues);

      pushFields = pushFields.equal(serialization.colorsName, false, v);
      return this;
    }

  }

  @Generated(from = "Flower", generator = "Repositories")
  @NotThreadSafe
  public static final class Modifier extends Repositories.Modifier<Flower, Modifier> {
    private final Serialization serialization;

    private Modifier(
        FlowerRepository repository,
        Constraints.ConstraintHost criteria,
        Constraints.Constraint ordering,
        Constraints.Constraint exclusion) {
      super(repository);
      this.serialization = repository.serialization;
      this.criteria = criteria;
      this.ordering = ordering;
      this.exclusion = exclusion;
    }

    /**
     * Specify a new value for the {@code id} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code id} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setId(ObjectId value) {
      setFields = setFields.equal(serialization.idName, false, Support.writable(serialization.idEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code id} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code id} value for an insert.
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier initId(ObjectId value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.idName, false, Support.writable(serialization.idEncoder, value));
      return this;
    }


    /**
     * Specify a new value for the {@code name} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code name} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setName(java.lang.String value) {
      setFields = setFields.equal(serialization.nameName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an initial value for the {@code name} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code name} value for an insert.
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier initName(java.lang.String value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.nameName, false, Support.writable(value));
      return this;
    }


    /**
     * Specify a new value for the {@code isBlooming} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code isBlooming} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setIsBlooming(Boolean value) {
      setFields = setFields.equal(serialization.isBloomingName, false, Support.writable(serialization.isBloomingEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code isBlooming} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code isBlooming} value for an insert.
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier initIsBlooming(Boolean value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.isBloomingName, false, Support.writable(serialization.isBloomingEncoder, value));
      return this;
    }


    /**
     * Specify a new value for the {@code height} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code height} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setHeight(Float value) {
      setFields = setFields.equal(serialization.heightName, false, Support.writable(serialization.heightEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code height} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code height} value for an insert.
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier initHeight(Float value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.heightName, false, Support.writable(serialization.heightEncoder, value));
      return this;
    }


    /**
     * Clear the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator resetting to empty array
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier clearColors() {
      setFields = setFields.equal(serialization.colorsName, false, ImmutableList.<Object>of());
      return this;
    }

    /**
     * Remove a value from the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $pull} operator.
     * @param value The value to remove
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier removeColors(java.lang.String value) {
      pullFields = pullFields.equal(serialization.colorsName, false, Support.writable(value));
      return this;
    }

    /**
     * Add a value to the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $push} operator.
     * @param value The value to add
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier addColors(java.lang.String value) {
      pushFields = pushFields.equal(serialization.colorsName, false, Support.writable(value));
      return this;
    }

    /**
     * Override all values of {@code colors} list attribute.
     *
     * <p>Corresponds to the MongoDB {@code $set} operator on the array field.
     * @param values The values to set
     * @return {@code this} modifier to be used to complete the update operation
     */
     public Modifier setColors(Iterable<java.lang.String> values) {
       List<Object> wrappedValues = new ArrayList<>();
       for (java.lang.String value : values) {
         wrappedValues.add(Support.writable(value));
       }

       setFields = setFields.equal(serialization.colorsName, false, wrappedValues);
       return this;
     }

    /**
     * Add all of the given values to the {@code colors} list attribute.
     * <p>
     * Corresponds to the MongoDB {@code $push} operator with the {@code $each} modifier.
     * @param values The values to add
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier addAllColors(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      if (wrappedValues.isEmpty()) {
        return this;
      }
      Object v = wrappedValues.size() == 1
          ? wrappedValues.get(0)
          : Support.bsonObjectAttribute("$each", wrappedValues);

      pushFields = pushFields.equal(serialization.colorsName, false, v);
      return this;
    }

  }

  @Generated(from = "Flower", generator = "Repositories")
  @NotThreadSafe
  public static final class Replacer extends Repositories.Replacer<Flower, Replacer> {
    protected Replacer(FlowerRepository repository, Flower document, Constraints.ConstraintHost criteria, Constraints.Constraint ordering) {
      super(repository, document, criteria, ordering);
    }
  }

  /**
   * {@link DBCollection#createIndex(DBObject, DBObject) Ensure an index} on collection flower by one or
   * more attributes using the family of {@code with*()} attribute-specific methods.
   * While indexes will usually be maintained by special administration scripts, for simple cases it is convenient
   * to ensure an index on application startup.
   * @see Indexer#named(String)
   * @see Indexer#unique()
   * @return An indexer object to be completed with the {@link Indexer#ensure()} operation.
   */
  @CheckReturnValue
  public Indexer index() {
    return new Indexer(this);
  }

  /**
   * An indexer used to create an index on the {@code "flower"} collection if it does not exist by one or more attributes.
   * @see DBCollection#createIndex(DBObject, DBObject)
   */
  @Generated(from = "Flower", generator = "Repositories")
  @NotThreadSafe
  public static final class Indexer extends Repositories.Indexer<Flower, Indexer> {
    private final Serialization serialization;

    private Indexer(FlowerRepository repository) {
      super(repository);
      this.serialization = repository.serialization;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getId() id}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withId() {
      fields = fields.equal(serialization.idName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getId() id}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withIdDesceding() {
      fields = fields.equal(serialization.idName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getName() name}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withName() {
      fields = fields.equal(serialization.nameName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getName() name}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withNameDesceding() {
      fields = fields.equal(serialization.nameName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getIsBlooming() isBlooming}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withIsBlooming() {
      fields = fields.equal(serialization.isBloomingName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getIsBlooming() isBlooming}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withIsBloomingDesceding() {
      fields = fields.equal(serialization.isBloomingName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getHeight() height}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withHeight() {
      fields = fields.equal(serialization.heightName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getHeight() height}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withHeightDesceding() {
      fields = fields.equal(serialization.heightName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getColors() colors}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withColors() {
      fields = fields.equal(serialization.colorsName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Flower#getColors() colors}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withColorsDesceding() {
      fields = fields.equal(serialization.colorsName, false, -1);
      return this;
    }
  }

  /**
   * Search criteria.
   * Returns an initial object to create criteria by invoking methods that describe attribute specific constraints.
   * @return An empty immutable criteria
   */
  public Criteria criteria() {
    return anyCriteria;
  }

  @Beta
  Bson toBson(Criteria criteria) {
    return Support.convertToBson(criteria.constraint);
  }

  /**
   * {@code FlowerRepository.Criteria} is a Flower document search query.
   * Call methods on the criteria to add constraints for search queries.
   */
  @Generated(from = "Flower", generator = "Repositories")
  @Immutable
  @SuppressWarnings("unchecked")
  public static final class Criteria extends Repositories.Criteria {
    private final Constraints.Constraint constraint;
    private final Serialization serialization;

    Criteria(Serialization serialization, Constraints.Constraint constraint) {
      this.constraint = constraint;
      this.serialization = serialization;
    }

    public Criteria id(ObjectId value) {
      return new Criteria(serialization, constraint.equal(serialization.idName, false, Support.writable(serialization.idEncoder, value)));
    }

    public Criteria idNot(ObjectId value) {
      return new Criteria(serialization, constraint.equal(serialization.idName, true, Support.writable(serialization.idEncoder, value)));
    }

    public Criteria idIn(Iterable<ObjectId> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (ObjectId value : values) {
        wrappedValues.add(Support.writable(serialization.idEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, false, wrappedValues));
    }

    public Criteria idIn(ObjectId first, ObjectId second, ObjectId... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.idEncoder, first));
      values.add(Support.writable(serialization.idEncoder, second));
      for (ObjectId value : rest) {
        values.add(Support.writable(serialization.idEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, false, values));
    }

    public Criteria idNotIn(Iterable<ObjectId> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (ObjectId value : values) {
        wrappedValues.add(Support.writable(serialization.idEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, true, wrappedValues));
    }

    public Criteria idNotIn(ObjectId first, ObjectId second, ObjectId... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.idEncoder, first));
      values.add(Support.writable(serialization.idEncoder, second));
      for (ObjectId value : rest) {
        values.add(Support.writable(serialization.idEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, true, values));
    }

    public Criteria idGreaterThan(ObjectId lower) {
      return idIn(Range.greaterThan(lower));
    }

    public Criteria idLessThan(ObjectId upper) {
      return idIn(Range.lessThan(upper));
    }

    public Criteria idAtMost(ObjectId upperInclusive) {
      return idIn(Range.atMost(upperInclusive));
    }

    public Criteria idAtLeast(ObjectId lowerInclusive) {
      return idIn(Range.atLeast(lowerInclusive));
    }

    public Criteria idIn(Range<ObjectId> range) {
      return new Criteria(serialization, constraint.range(serialization.idName, false, Support.writable(serialization.idEncoder, range)));
    }

    public Criteria idNotIn(Range<ObjectId> range) {
      return new Criteria(serialization, constraint.range(serialization.idName, true, Support.writable(serialization.idEncoder, range)));
    }

    public Criteria name(java.lang.String value) {
      return new Criteria(serialization, constraint.equal(serialization.nameName, false, Support.writable(value)));
    }

    public Criteria nameNot(java.lang.String value) {
      return new Criteria(serialization, constraint.equal(serialization.nameName, true, Support.writable(value)));
    }

    public Criteria nameIn(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.nameName, false, wrappedValues));
    }

    public Criteria nameIn(java.lang.String first, java.lang.String second, java.lang.String... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (java.lang.String value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.nameName, false, values));
    }

    public Criteria nameNotIn(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.nameName, true, wrappedValues));
    }

    public Criteria nameNotIn(java.lang.String first, java.lang.String second, java.lang.String... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (java.lang.String value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.nameName, true, values));
    }

    public Criteria nameStartsWith(String prefix) {
      return new Criteria(serialization, constraint.match(serialization.nameName, false, Constraints.prefixPatternOf(prefix)));
    }

    public Criteria nameMatches(Pattern pattern) {
      return new Criteria(serialization, constraint.match(serialization.nameName, false, pattern));
    }

    public Criteria nameNotMatches(Pattern pattern) {
      return new Criteria(serialization, constraint.match(serialization.nameName, true, pattern));
    }

    public Criteria nameGreaterThan(java.lang.String lower) {
      return nameIn(Range.greaterThan(lower));
    }

    public Criteria nameLessThan(java.lang.String upper) {
      return nameIn(Range.lessThan(upper));
    }

    public Criteria nameAtMost(java.lang.String upperInclusive) {
      return nameIn(Range.atMost(upperInclusive));
    }

    public Criteria nameAtLeast(java.lang.String lowerInclusive) {
      return nameIn(Range.atLeast(lowerInclusive));
    }

    public Criteria nameIn(Range<java.lang.String> range) {
      return new Criteria(serialization, constraint.range(serialization.nameName, false, Support.writable(range)));
    }

    public Criteria nameNotIn(Range<java.lang.String> range) {
      return new Criteria(serialization, constraint.range(serialization.nameName, true, Support.writable(range)));
    }

    public Criteria isBlooming(Boolean value) {
      return new Criteria(serialization, constraint.equal(serialization.isBloomingName, false, Support.writable(serialization.isBloomingEncoder, value)));
    }

    public Criteria isBloomingNot(Boolean value) {
      return new Criteria(serialization, constraint.equal(serialization.isBloomingName, true, Support.writable(serialization.isBloomingEncoder, value)));
    }

    public Criteria isBloomingIn(Iterable<Boolean> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (Boolean value : values) {
        wrappedValues.add(Support.writable(serialization.isBloomingEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.isBloomingName, false, wrappedValues));
    }

    public Criteria isBloomingIn(Boolean first, Boolean second, Boolean... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.isBloomingEncoder, first));
      values.add(Support.writable(serialization.isBloomingEncoder, second));
      for (Boolean value : rest) {
        values.add(Support.writable(serialization.isBloomingEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.isBloomingName, false, values));
    }

    public Criteria isBloomingNotIn(Iterable<Boolean> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (Boolean value : values) {
        wrappedValues.add(Support.writable(serialization.isBloomingEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.isBloomingName, true, wrappedValues));
    }

    public Criteria isBloomingNotIn(Boolean first, Boolean second, Boolean... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.isBloomingEncoder, first));
      values.add(Support.writable(serialization.isBloomingEncoder, second));
      for (Boolean value : rest) {
        values.add(Support.writable(serialization.isBloomingEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.isBloomingName, true, values));
    }

    public Criteria isBloomingGreaterThan(Boolean lower) {
      return isBloomingIn(Range.greaterThan(lower));
    }

    public Criteria isBloomingLessThan(Boolean upper) {
      return isBloomingIn(Range.lessThan(upper));
    }

    public Criteria isBloomingAtMost(Boolean upperInclusive) {
      return isBloomingIn(Range.atMost(upperInclusive));
    }

    public Criteria isBloomingAtLeast(Boolean lowerInclusive) {
      return isBloomingIn(Range.atLeast(lowerInclusive));
    }

    public Criteria isBloomingIn(Range<Boolean> range) {
      return new Criteria(serialization, constraint.range(serialization.isBloomingName, false, Support.writable(serialization.isBloomingEncoder, range)));
    }

    public Criteria isBloomingNotIn(Range<Boolean> range) {
      return new Criteria(serialization, constraint.range(serialization.isBloomingName, true, Support.writable(serialization.isBloomingEncoder, range)));
    }

    public Criteria height(Float value) {
      return new Criteria(serialization, constraint.equal(serialization.heightName, false, Support.writable(serialization.heightEncoder, value)));
    }

    public Criteria heightNot(Float value) {
      return new Criteria(serialization, constraint.equal(serialization.heightName, true, Support.writable(serialization.heightEncoder, value)));
    }

    public Criteria heightIn(Iterable<Float> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (Float value : values) {
        wrappedValues.add(Support.writable(serialization.heightEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, false, wrappedValues));
    }

    public Criteria heightIn(Float first, Float second, Float... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.heightEncoder, first));
      values.add(Support.writable(serialization.heightEncoder, second));
      for (Float value : rest) {
        values.add(Support.writable(serialization.heightEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, false, values));
    }

    public Criteria heightNotIn(Iterable<Float> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (Float value : values) {
        wrappedValues.add(Support.writable(serialization.heightEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, true, wrappedValues));
    }

    public Criteria heightNotIn(Float first, Float second, Float... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.heightEncoder, first));
      values.add(Support.writable(serialization.heightEncoder, second));
      for (Float value : rest) {
        values.add(Support.writable(serialization.heightEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, true, values));
    }

    public Criteria heightGreaterThan(Float lower) {
      return heightIn(Range.greaterThan(lower));
    }

    public Criteria heightLessThan(Float upper) {
      return heightIn(Range.lessThan(upper));
    }

    public Criteria heightAtMost(Float upperInclusive) {
      return heightIn(Range.atMost(upperInclusive));
    }

    public Criteria heightAtLeast(Float lowerInclusive) {
      return heightIn(Range.atLeast(lowerInclusive));
    }

    public Criteria heightIn(Range<Float> range) {
      return new Criteria(serialization, constraint.range(serialization.heightName, false, Support.writable(serialization.heightEncoder, range)));
    }

    public Criteria heightNotIn(Range<Float> range) {
      return new Criteria(serialization, constraint.range(serialization.heightName, true, Support.writable(serialization.heightEncoder, range)));
    }

    public Criteria colorsEmpty() {
      return new Criteria(serialization, constraint.size(serialization.colorsName, false, 0));
    }

    public Criteria colorsNonEmpty() {
      return new Criteria(serialization, constraint.size(serialization.colorsName, true, 0));
    }

    public Criteria colorsSize(int size) {
      return new Criteria(serialization, constraint.size(serialization.colorsName, false, size));
    }

    public Criteria colorsContains(java.lang.String value) {
      return new Criteria(serialization, constraint.equal(serialization.colorsName, false, Support.writable(value)));
    }

    public Criteria colorsContainsAll(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.nested(serialization.colorsName, Constraints.nilConstraint().equal("$all", false, wrappedValues)));
    }

    public Criteria colorsAnyStartsWith(String prefix) {
      return new Criteria(serialization, constraint.match(serialization.colorsName, false, Constraints.prefixPatternOf(prefix)));
    }

    public Criteria colorsAnyMatches(Pattern pattern) {
      return new Criteria(serialization, constraint.match(serialization.colorsName, false, pattern));
    }

    @Override
    public Criteria or() {
      return new Criteria(serialization, constraint.disjunction());
    }

    public Criteria with(Criteria criteria) {
      return new Criteria(serialization, criteria.constraint.accept(constraint));
    }

    @Override
    public String toString() {
      return "FlowerRepository.criteria(" + Support.stringify(constraint) + ")";
    }
  }

  @Generated(from = "Flower", generator = "Repositories")
  private static class Serialization {
    final Encoder<ObjectId> idEncoder;
    final Encoder<Boolean> isBloomingEncoder;
    final Encoder<Float> heightEncoder;
    final CodecRegistry registry;
    final String idName;
    final String nameName;
    final String isBloomingName;
    final String heightName;
    final String colorsName;

    Serialization(CodecRegistry registry, RepositorySetup.FieldNamingStrategy fieldNamingStrategy) {
      this.registry = registry;
      this.idEncoder = this.registry.get(ObjectId.class);
      this.isBloomingEncoder = this.registry.get(Boolean.class);
      this.heightEncoder = this.registry.get(Float.class);
      this.idName = "_id";
      this.nameName = translateName(fieldNamingStrategy, "name");
      this.isBloomingName = translateName(fieldNamingStrategy, "isBlooming");
      this.heightName = translateName(fieldNamingStrategy, "height");
      this.colorsName = translateName(fieldNamingStrategy, "colors");
    }

    @Generated(from = "Flower", generator = "Repositories")
    static final class FlowerNamingFields {
      public ObjectId id;
      public java.lang.String name;
      public Boolean isBlooming;
      public Float height;
      public List<java.lang.String> colors;
    }

    private static String translateName(RepositorySetup.FieldNamingStrategy fieldNamingStrategy, String fieldName) {
      try {
        return fieldNamingStrategy.translateName(
            FlowerNamingFields.class.getField(fieldName));
      } catch (NoSuchFieldException noSuchField) {
        throw new AssertionError(noSuchField);
      }
    }
  }
}
