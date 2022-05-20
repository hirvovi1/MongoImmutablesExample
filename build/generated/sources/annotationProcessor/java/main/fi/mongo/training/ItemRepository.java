package fi.mongo.training;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import org.bson.codecs.Encoder;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.immutables.mongo.concurrent.FluentFuture;
import org.immutables.mongo.repository.Repositories;
import org.immutables.mongo.repository.RepositorySetup;
import org.immutables.mongo.repository.internal.Constraints;
import org.immutables.mongo.repository.internal.Support;
import org.immutables.value.Generated;

/**
 * A {@code ItemRepository} provides type-safe access for storing and retrieving documents
 * from the MongoDB collection {@code "item"}.
 */
@Generated(from = "Item", generator = "Repositories")
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@ThreadSafe
public class ItemRepository extends Repositories.Repository<Item> {
  private static final String DOCUMENT_COLLECTION_NAME = "item";

  private final Serialization serialization;
  private final Criteria anyCriteria;

  /**
   * Constructs a {@link Item} repository using {@link RepositorySetup configuration}.
   * @param configuration The repository configuration
   */
  public ItemRepository(RepositorySetup configuration) {
    super(configuration, DOCUMENT_COLLECTION_NAME, Item.class);
    this.serialization = new Serialization(codecRegistry(), fieldNamingStrategy());
    this.anyCriteria = new Criteria(this.serialization, Constraints.nilConstraint());
  }

  /**
   * Inserts a single document into the collection.
   * @param document The item to insert
   * @return A future representing the number of inserted documents (1) if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> insert(Item document) {
    return super.doInsert(ImmutableList.of(document));
  }

  /**
   * Insert documents into the collection.
   * @param documents The documents to insert
   * @return A future representing the number of inserted documents if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> insert(Iterable<? extends Item> documents) {
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
   * Find documents by the {@link Item#id() id} identity attribute. Use the returned {@link Finder} object to complete
   * {@link Finder#fetchFirst() fetch} or {@link Finder#fetchAll() fetchAll} read operations.
   * You can also use {@link Finder#andModifyFirst() modify}, {@link Finder#andReplaceFirst(Item) replace}
   * or {@link Finder#deleteFirst() delete} operations to update / delete the document.
   * @param id The exact {@code id} value
   * @return A finder object used to complete operations
   */
  @CheckReturnValue
  public Finder findById(long id) {
    return find(criteria().id(id));
  }

  /**
   * Update or insert a document, matched by the identifier value of the 'id' attribute.
   * @param document The item to upsert
   * @return A future representing the of number of inserted documents (1) if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> upsert(Item document) {
    Criteria byId = criteria().id(document.id());
    return super.doUpsert(byId.constraint, document);
  }

  /**
   * Find a document by the given {@link ItemRepository#criteria() criteria}. Use the returned {@link Finder} object to complete
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
   * @see ItemRepository#find(Criteria)
   */
  @Generated(from = "Item", generator = "Repositories")
  @NotThreadSafe
  public static final class Finder extends Repositories.FinderWithDelete<Item, Finder> {
    private final Serialization serialization;

    private Finder(ItemRepository repository, Constraints.ConstraintHost criteria) {
      super(repository);
      this.criteria = criteria;
      this.serialization = repository.serialization;
    }

    /**
     * Order by {@link Item#id() id} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Item#id() id} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderById() {
      ordering = ordering.equal(serialization.idName, false, 1);
      return this;
    }

    /**
     * Order by {@link Item#id() id} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Item#id() id} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByIdDesceding() {
      ordering = ordering.equal(serialization.idName, false, -1);
      return this;
    }

    /**
     * Order by {@link Item#name() name} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Item#name() name} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByName() {
      ordering = ordering.equal(serialization.nameName, false, 1);
      return this;
    }

    /**
     * Order by {@link Item#name() name} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Item#name() name} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByNameDesceding() {
      ordering = ordering.equal(serialization.nameName, false, -1);
      return this;
    }

    /**
     * Order by {@link Item#values() values} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Item#values() values} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByValues() {
      ordering = ordering.equal(serialization.valuesName, false, 1);
      return this;
    }

    /**
     * Order by {@link Item#values() values} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Item#values() values} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByValuesDesceding() {
      ordering = ordering.equal(serialization.valuesName, false, -1);
      return this;
    }

    /**
     * Order by {@link Item#comment() comment} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Item#comment() comment} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByComment() {
      ordering = ordering.equal(serialization.commentName, false, 1);
      return this;
    }

    /**
     * Order by {@link Item#comment() comment} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Item#comment() comment} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByCommentDesceding() {
      ordering = ordering.equal(serialization.commentName, false, -1);
      return this;
    }

    /**
     * Exclude the {@link Item#values() values} attribute from each document in the results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder excludeValues() {
      exclusion = exclusion.equal(serialization.valuesName, false, -1);
      return this;
    }

    /**
     * Exclude the {@link Item#comment() comment} attribute from each document in the results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder excludeComment() {
      exclusion = exclusion.equal(serialization.commentName, false, -1);
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
      return new Modifier((ItemRepository) repository, criteria, ordering, exclusion);
    }

    /**
     * Used to replace in-place existing version of the document
     */
    @CheckReturnValue
    public Replacer andReplaceFirst(Item document) {
      return new Replacer((ItemRepository) repository, document, criteria, ordering);
    }
  }

  /**
   * Update the set of {@code "item"} documents.
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
  @Generated(from = "Item", generator = "Repositories")
  @NotThreadSafe
  public static final class Updater extends Repositories.Updater<Item> {
    private final Serialization serialization;

    private Updater(ItemRepository repository, Criteria criteria) {
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
    public Updater setId(long value) {
      setFields = setFields.equal(serialization.idName, false, Support.writable(value));
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
    public Updater initId(long value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.idName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an increment amount for the {@code id} attribute. If the document is to inserted
     * and no initial value has been provided, then {@code 0} will be the default value and the increment will adjust it.
     * <p>
     * Corresponds to the MongoDB {@code $inc} operator.
     * @param increment An amount by which to increment the {@code id} attribute (may be negative)
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater incrementId(long increment) {
      incrementFields = incrementFields.equal(serialization.idName, false, increment);
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
     * Clear the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator resetting to empty array
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater clearValues() {
      setFields = setFields.equal(serialization.valuesName, false, ImmutableList.<Object>of());
      return this;
    }

    /**
     * Remove a value from the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $pull} operator.
     * @param value The value to remove
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater removeValues(int value) {
      pullFields = pullFields.equal(serialization.valuesName, false, Support.writable(serialization.valuesEncoder, value));
      return this;
    }

    /**
     * Add a value to the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $addToSet} operator.
     * @param value The value to add
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater addValues(int value) {
      addToSetFields = addToSetFields.equal(serialization.valuesName, false, Support.writable(serialization.valuesEncoder, value));
      return this;
    }

    /**
     * Override all values of {@code values} set attribute.
     *
     * <p>Corresponds to the MongoDB {@code $set} operator on the array field.
     * @param values The values to set
     * @return {@code this} updater to be used to complete the update operation
     */
     public Updater setValues(Iterable<java.lang.Integer> values) {
       List<Object> wrappedValues = new ArrayList<>();
       for (java.lang.Integer value : values) {
         wrappedValues.add(Support.writable(serialization.valuesEncoder, value));
       }

       setFields = setFields.equal(serialization.valuesName, false, wrappedValues);
       return this;
     }

    /**
     * Add all of the given values to the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $addToSet} operator with the {@code $each} modifier.
     * @param values The values to add
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater addAllValues(Iterable<java.lang.Integer> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.Integer value : values) {
        wrappedValues.add(Support.writable(serialization.valuesEncoder, value));
      }
      if (wrappedValues.isEmpty()) {
        return this;
      }
      Object v = wrappedValues.size() == 1
          ? wrappedValues.get(0)
          : Support.bsonObjectAttribute("$each", wrappedValues);

      addToSetFields = addToSetFields.equal(serialization.valuesName, false, v);
      return this;
    }


    /**
     * Clear the optional {@code comment} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator resetting to {@code null}
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater emptyComment() {
      setFields = setFields.equal(serialization.commentName, false, null);
      return this;
    }

    /**
     * Specify a new value for the {@code comment} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code comment} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setComment(java.lang.String value) {
      setFields = setFields.equal(serialization.commentName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an initial value for the {@code comment} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code comment} value for an insert.
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater initComment(java.lang.String value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.commentName, false, Support.writable(value));
      return this;
    }

  }

  @Generated(from = "Item", generator = "Repositories")
  @NotThreadSafe
  public static final class Modifier extends Repositories.Modifier<Item, Modifier> {
    private final Serialization serialization;

    private Modifier(
        ItemRepository repository,
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
    public Modifier setId(long value) {
      setFields = setFields.equal(serialization.idName, false, Support.writable(value));
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
    public Modifier initId(long value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.idName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an increment amount for the {@code id} attribute. If the document is to inserted
     * and no initial value has been provided, then {@code 0} will be the default value and the increment will adjust it.
     * <p>
     * Corresponds to the MongoDB {@code $inc} operator.
     * @param increment An amount by which to increment the {@code id} attribute (may be negative)
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier incrementId(long increment) {
      incrementFields = incrementFields.equal(serialization.idName, false, increment);
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
     * Clear the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator resetting to empty array
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier clearValues() {
      setFields = setFields.equal(serialization.valuesName, false, ImmutableList.<Object>of());
      return this;
    }

    /**
     * Remove a value from the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $pull} operator.
     * @param value The value to remove
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier removeValues(int value) {
      pullFields = pullFields.equal(serialization.valuesName, false, Support.writable(serialization.valuesEncoder, value));
      return this;
    }

    /**
     * Add a value to the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $addToSet} operator.
     * @param value The value to add
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier addValues(int value) {
      addToSetFields = addToSetFields.equal(serialization.valuesName, false, Support.writable(serialization.valuesEncoder, value));
      return this;
    }

    /**
     * Override all values of {@code values} set attribute.
     *
     * <p>Corresponds to the MongoDB {@code $set} operator on the array field.
     * @param values The values to set
     * @return {@code this} modifier to be used to complete the update operation
     */
     public Modifier setValues(Iterable<java.lang.Integer> values) {
       List<Object> wrappedValues = new ArrayList<>();
       for (java.lang.Integer value : values) {
         wrappedValues.add(Support.writable(serialization.valuesEncoder, value));
       }

       setFields = setFields.equal(serialization.valuesName, false, wrappedValues);
       return this;
     }

    /**
     * Add all of the given values to the {@code values} set attribute.
     * <p>
     * Corresponds to the MongoDB {@code $addToSet} operator with the {@code $each} modifier.
     * @param values The values to add
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier addAllValues(Iterable<java.lang.Integer> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.Integer value : values) {
        wrappedValues.add(Support.writable(serialization.valuesEncoder, value));
      }
      if (wrappedValues.isEmpty()) {
        return this;
      }
      Object v = wrappedValues.size() == 1
          ? wrappedValues.get(0)
          : Support.bsonObjectAttribute("$each", wrappedValues);

      addToSetFields = addToSetFields.equal(serialization.valuesName, false, v);
      return this;
    }


    /**
     * Clear the optional {@code comment} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator resetting to {@code null}
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier emptyComment() {
      setFields = setFields.equal(serialization.commentName, false, null);
      return this;
    }

    /**
     * Specify a new value for the {@code comment} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code comment} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setComment(java.lang.String value) {
      setFields = setFields.equal(serialization.commentName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an initial value for the {@code comment} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code comment} value for an insert.
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier initComment(java.lang.String value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.commentName, false, Support.writable(value));
      return this;
    }

  }

  @Generated(from = "Item", generator = "Repositories")
  @NotThreadSafe
  public static final class Replacer extends Repositories.Replacer<Item, Replacer> {
    protected Replacer(ItemRepository repository, Item document, Constraints.ConstraintHost criteria, Constraints.Constraint ordering) {
      super(repository, document, criteria, ordering);
    }
  }

  /**
   * {@link DBCollection#createIndex(DBObject, DBObject) Ensure an index} on collection item by one or
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
   * An indexer used to create an index on the {@code "item"} collection if it does not exist by one or more attributes.
   * @see DBCollection#createIndex(DBObject, DBObject)
   */
  @Generated(from = "Item", generator = "Repositories")
  @NotThreadSafe
  public static final class Indexer extends Repositories.Indexer<Item, Indexer> {
    private final Serialization serialization;

    private Indexer(ItemRepository repository) {
      super(repository);
      this.serialization = repository.serialization;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#id() id}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withId() {
      fields = fields.equal(serialization.idName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#id() id}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withIdDesceding() {
      fields = fields.equal(serialization.idName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#name() name}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withName() {
      fields = fields.equal(serialization.nameName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#name() name}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withNameDesceding() {
      fields = fields.equal(serialization.nameName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#values() values}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withValues() {
      fields = fields.equal(serialization.valuesName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#values() values}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withValuesDesceding() {
      fields = fields.equal(serialization.valuesName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#comment() comment}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withComment() {
      fields = fields.equal(serialization.commentName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Item#comment() comment}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withCommentDesceding() {
      fields = fields.equal(serialization.commentName, false, -1);
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
   * {@code ItemRepository.Criteria} is a Item document search query.
   * Call methods on the criteria to add constraints for search queries.
   */
  @Generated(from = "Item", generator = "Repositories")
  @Immutable
  @SuppressWarnings("unchecked")
  public static final class Criteria extends Repositories.Criteria {
    private final Constraints.Constraint constraint;
    private final Serialization serialization;

    Criteria(Serialization serialization, Constraints.Constraint constraint) {
      this.constraint = constraint;
      this.serialization = serialization;
    }

    public Criteria id(long value) {
      return new Criteria(serialization, constraint.equal(serialization.idName, false, Support.writable(value)));
    }

    public Criteria idNot(long value) {
      return new Criteria(serialization, constraint.equal(serialization.idName, true, Support.writable(value)));
    }

    public Criteria idIn(Iterable<Long> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (Long value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, false, wrappedValues));
    }

    public Criteria idIn(long first, long second, long... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (long value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, false, values));
    }

    public Criteria idNotIn(Iterable<Long> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (Long value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, true, wrappedValues));
    }

    public Criteria idNotIn(long first, long second, long... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (long value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.idName, true, values));
    }

    public Criteria idGreaterThan(long lower) {
      return idIn(Range.greaterThan(lower));
    }

    public Criteria idLessThan(long upper) {
      return idIn(Range.lessThan(upper));
    }

    public Criteria idAtMost(long upperInclusive) {
      return idIn(Range.atMost(upperInclusive));
    }

    public Criteria idAtLeast(long lowerInclusive) {
      return idIn(Range.atLeast(lowerInclusive));
    }

    public Criteria idIn(Range<Long> range) {
      return new Criteria(serialization, constraint.range(serialization.idName, false, Support.writable(range)));
    }

    public Criteria idNotIn(Range<Long> range) {
      return new Criteria(serialization, constraint.range(serialization.idName, true, Support.writable(range)));
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

    public Criteria valuesEmpty() {
      return new Criteria(serialization, constraint.size(serialization.valuesName, false, 0));
    }

    public Criteria valuesNonEmpty() {
      return new Criteria(serialization, constraint.size(serialization.valuesName, true, 0));
    }

    public Criteria valuesSize(int size) {
      return new Criteria(serialization, constraint.size(serialization.valuesName, false, size));
    }

    public Criteria valuesContains(int value) {
      return new Criteria(serialization, constraint.equal(serialization.valuesName, false, Support.writable(serialization.valuesEncoder, value)));
    }

    public Criteria valuesContainsAll(Iterable<java.lang.Integer> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.Integer value : values) {
        wrappedValues.add(Support.writable(serialization.valuesEncoder, value));
      }
      return new Criteria(serialization, constraint.nested(serialization.valuesName, Constraints.nilConstraint().equal("$all", false, wrappedValues)));
    }

    public Criteria comment(java.lang.String value) {
      return new Criteria(serialization, constraint.equal(serialization.commentName, false, Support.writable(value)));
    }

    public Criteria commentNot(java.lang.String value) {
      return new Criteria(serialization, constraint.equal(serialization.commentName, true, Support.writable(value)));
    }

    public Criteria commentIn(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.commentName, false, wrappedValues));
    }

    public Criteria commentIn(java.lang.String first, java.lang.String second, java.lang.String... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (java.lang.String value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.commentName, false, values));
    }

    public Criteria commentNotIn(Iterable<java.lang.String> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.String value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.commentName, true, wrappedValues));
    }

    public Criteria commentNotIn(java.lang.String first, java.lang.String second, java.lang.String... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (java.lang.String value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.commentName, true, values));
    }

    public Criteria commentStartsWith(String prefix) {
      return new Criteria(serialization, constraint.match(serialization.commentName, false, Constraints.prefixPatternOf(prefix)));
    }

    public Criteria commentMatches(Pattern pattern) {
      return new Criteria(serialization, constraint.match(serialization.commentName, false, pattern));
    }

    public Criteria commentNotMatches(Pattern pattern) {
      return new Criteria(serialization, constraint.match(serialization.commentName, true, pattern));
    }

    public Criteria commentPresent() {
      return new Criteria(serialization, constraint.present(serialization.commentName, false));
    }

    public Criteria commentAbsent() {
      return new Criteria(serialization, constraint.present(serialization.commentName, true));
    }

    public Criteria commentGreaterThan(java.lang.String lower) {
      return commentIn(Range.greaterThan(lower));
    }

    public Criteria commentLessThan(java.lang.String upper) {
      return commentIn(Range.lessThan(upper));
    }

    public Criteria commentAtMost(java.lang.String upperInclusive) {
      return commentIn(Range.atMost(upperInclusive));
    }

    public Criteria commentAtLeast(java.lang.String lowerInclusive) {
      return commentIn(Range.atLeast(lowerInclusive));
    }

    public Criteria commentIn(Range<java.lang.String> range) {
      return new Criteria(serialization, constraint.range(serialization.commentName, false, Support.writable(range)));
    }

    public Criteria commentNotIn(Range<java.lang.String> range) {
      return new Criteria(serialization, constraint.range(serialization.commentName, true, Support.writable(range)));
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
      return "ItemRepository.criteria(" + Support.stringify(constraint) + ")";
    }
  }

  @Generated(from = "Item", generator = "Repositories")
  private static class Serialization {
    final Encoder<java.lang.Integer> valuesEncoder;
    final CodecRegistry registry;
    final String idName;
    final String nameName;
    final String valuesName;
    final String commentName;

    Serialization(CodecRegistry registry, RepositorySetup.FieldNamingStrategy fieldNamingStrategy) {
      this.registry = registry;
      this.valuesEncoder = this.registry.get(java.lang.Integer.class);
      this.idName = "_id";
      this.nameName = translateName(fieldNamingStrategy, "name");
      this.valuesName = translateName(fieldNamingStrategy, "values");
      this.commentName = translateName(fieldNamingStrategy, "comment");
    }

    @Generated(from = "Item", generator = "Repositories")
    static final class ItemNamingFields {
      public long id;
      public java.lang.String name;
      public Set<java.lang.Integer> values;
      public Optional<java.lang.String> comment;
    }

    private static String translateName(RepositorySetup.FieldNamingStrategy fieldNamingStrategy, String fieldName) {
      try {
        return fieldNamingStrategy.translateName(
            ItemNamingFields.class.getField(fieldName));
      } catch (NoSuchFieldException noSuchField) {
        throw new AssertionError(noSuchField);
      }
    }
  }
}
