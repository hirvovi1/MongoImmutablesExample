package fi.mongo.training;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
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
 * A {@code TreeRepository} provides type-safe access for storing and retrieving documents
 * from the MongoDB collection {@code "tree"}.
 */
@Generated(from = "Tree", generator = "Repositories")
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@ThreadSafe
public class TreeRepository extends Repositories.Repository<Tree> {
  private static final String DOCUMENT_COLLECTION_NAME = "tree";

  private final Serialization serialization;
  private final Criteria anyCriteria;

  /**
   * Constructs a {@link Tree} repository using {@link RepositorySetup configuration}.
   * @param configuration The repository configuration
   */
  public TreeRepository(RepositorySetup configuration) {
    super(configuration, DOCUMENT_COLLECTION_NAME, Tree.class);
    this.serialization = new Serialization(codecRegistry(), fieldNamingStrategy());
    this.anyCriteria = new Criteria(this.serialization, Constraints.nilConstraint());
  }

  /**
   * Inserts a single document into the collection.
   * @param document The tree to insert
   * @return A future representing the number of inserted documents (1) if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> insert(Tree document) {
    return super.doInsert(ImmutableList.of(document));
  }

  /**
   * Insert documents into the collection.
   * @param documents The documents to insert
   * @return A future representing the number of inserted documents if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> insert(Iterable<? extends Tree> documents) {
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
   * Find documents by the {@link Tree#id() id} identity attribute. Use the returned {@link Finder} object to complete
   * {@link Finder#fetchFirst() fetch} or {@link Finder#fetchAll() fetchAll} read operations.
   * You can also use {@link Finder#andModifyFirst() modify}, {@link Finder#andReplaceFirst(Tree) replace}
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
   * @param document The tree to upsert
   * @return A future representing the of number of inserted documents (1) if WriteConcern allows the insertion.
   */
  public FluentFuture<Integer> upsert(Tree document) {
    Criteria byId = criteria().id(document.id());
    return super.doUpsert(byId.constraint, document);
  }

  /**
   * Find a document by the given {@link TreeRepository#criteria() criteria}. Use the returned {@link Finder} object to complete
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
   * @see TreeRepository#find(Criteria)
   */
  @Generated(from = "Tree", generator = "Repositories")
  @NotThreadSafe
  public static final class Finder extends Repositories.FinderWithDelete<Tree, Finder> {
    private final Serialization serialization;

    private Finder(TreeRepository repository, Constraints.ConstraintHost criteria) {
      super(repository);
      this.criteria = criteria;
      this.serialization = repository.serialization;
    }

    /**
     * Order by {@link Tree#id() id} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Tree#id() id} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderById() {
      ordering = ordering.equal(serialization.idName, false, 1);
      return this;
    }

    /**
     * Order by {@link Tree#id() id} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Tree#id() id} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByIdDesceding() {
      ordering = ordering.equal(serialization.idName, false, -1);
      return this;
    }

    /**
     * Order by {@link Tree#height() height} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Tree#height() height} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByHeight() {
      ordering = ordering.equal(serialization.heightName, false, 1);
      return this;
    }

    /**
     * Order by {@link Tree#height() height} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Tree#height() height} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderByHeightDesceding() {
      ordering = ordering.equal(serialization.heightName, false, -1);
      return this;
    }

    /**
     * Order by {@link Tree#species() species} in the ascending direction.
     * Specify that the next attribute to sort will be the {@link Tree#species() species} attribute using ascending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderBySpecies() {
      ordering = ordering.equal(serialization.speciesName, false, 1);
      return this;
    }

    /**
     * Order by {@link Tree#species() species} in the descending direction.
     * Specify that the next attribute to sort will be the {@link Tree#species() species} attribute using descending order
     * in the the chain of comparisons performed to sort results.
     * @return {@code this} finder for use in a chained invocation
     */
    public Finder orderBySpeciesDesceding() {
      ordering = ordering.equal(serialization.speciesName, false, -1);
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
      return new Modifier((TreeRepository) repository, criteria, ordering, exclusion);
    }

    /**
     * Used to replace in-place existing version of the document
     */
    @CheckReturnValue
    public Replacer andReplaceFirst(Tree document) {
      return new Replacer((TreeRepository) repository, document, criteria, ordering);
    }
  }

  /**
   * Update the set of {@code "tree"} documents.
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
  @Generated(from = "Tree", generator = "Repositories")
  @NotThreadSafe
  public static final class Updater extends Repositories.Updater<Tree> {
    private final Serialization serialization;

    private Updater(TreeRepository repository, Criteria criteria) {
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
     * Specify a new value for the {@code height} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code height} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setHeight(int value) {
      setFields = setFields.equal(serialization.heightName, false, Support.writable(value));
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
    public Updater initHeight(int value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.heightName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an increment amount for the {@code height} attribute. If the document is to inserted
     * and no initial value has been provided, then {@code 0} will be the default value and the increment will adjust it.
     * <p>
     * Corresponds to the MongoDB {@code $inc} operator.
     * @param increment An amount by which to increment the {@code height} attribute (may be negative)
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater incrementHeight(int increment) {
      incrementFields = incrementFields.equal(serialization.heightName, false, increment);
      return this;
    }

    /**
     * Specify a new value for the {@code species} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code species} attribute
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater setSpecies(TreeSpecies value) {
      setFields = setFields.equal(serialization.speciesName, false, Support.writable(serialization.speciesEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code species} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code species} value for an insert.
     * @return {@code this} updater to be used to complete the update operation
     */
    public Updater initSpecies(TreeSpecies value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.speciesName, false, Support.writable(serialization.speciesEncoder, value));
      return this;
    }

  }

  @Generated(from = "Tree", generator = "Repositories")
  @NotThreadSafe
  public static final class Modifier extends Repositories.Modifier<Tree, Modifier> {
    private final Serialization serialization;

    private Modifier(
        TreeRepository repository,
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
     * Specify a new value for the {@code height} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code height} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setHeight(int value) {
      setFields = setFields.equal(serialization.heightName, false, Support.writable(value));
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
    public Modifier initHeight(int value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.heightName, false, Support.writable(value));
      return this;
    }

    /**
     * Specify an increment amount for the {@code height} attribute. If the document is to inserted
     * and no initial value has been provided, then {@code 0} will be the default value and the increment will adjust it.
     * <p>
     * Corresponds to the MongoDB {@code $inc} operator.
     * @param increment An amount by which to increment the {@code height} attribute (may be negative)
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier incrementHeight(int increment) {
      incrementFields = incrementFields.equal(serialization.heightName, false, increment);
      return this;
    }

    /**
     * Specify a new value for the {@code species} attribute.
     * <p>
     * Corresponds to the MongoDB {@code $set} operator.
     * @param value A new value for the {@code species} attribute
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier setSpecies(TreeSpecies value) {
      setFields = setFields.equal(serialization.speciesName, false, Support.writable(serialization.speciesEncoder, value));
      return this;
    }

    /**
     * Specify an initial value for the {@code species} attribute. The value will be used if the document is
     * to be inserted. If one or more documents are found for an update, this value will not be used.
     * <p>
     * Corresponds to the MongoDB {@code $setOnInsert} operator.
     * @param value The {@code species} value for an insert.
     * @return {@code this} modifier to be used to complete the update operation
     */
    public Modifier initSpecies(TreeSpecies value) {
      setOnInsertFields = setOnInsertFields.equal(serialization.speciesName, false, Support.writable(serialization.speciesEncoder, value));
      return this;
    }

  }

  @Generated(from = "Tree", generator = "Repositories")
  @NotThreadSafe
  public static final class Replacer extends Repositories.Replacer<Tree, Replacer> {
    protected Replacer(TreeRepository repository, Tree document, Constraints.ConstraintHost criteria, Constraints.Constraint ordering) {
      super(repository, document, criteria, ordering);
    }
  }

  /**
   * {@link DBCollection#createIndex(DBObject, DBObject) Ensure an index} on collection tree by one or
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
   * An indexer used to create an index on the {@code "tree"} collection if it does not exist by one or more attributes.
   * @see DBCollection#createIndex(DBObject, DBObject)
   */
  @Generated(from = "Tree", generator = "Repositories")
  @NotThreadSafe
  public static final class Indexer extends Repositories.Indexer<Tree, Indexer> {
    private final Serialization serialization;

    private Indexer(TreeRepository repository) {
      super(repository);
      this.serialization = repository.serialization;
    }

    /**
     * Specify that the next attribute to index will be {@link Tree#id() id}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withId() {
      fields = fields.equal(serialization.idName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Tree#id() id}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withIdDesceding() {
      fields = fields.equal(serialization.idName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Tree#height() height}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withHeight() {
      fields = fields.equal(serialization.heightName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Tree#height() height}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withHeightDesceding() {
      fields = fields.equal(serialization.heightName, false, -1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Tree#species() species}, in the ascending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withSpecies() {
      fields = fields.equal(serialization.speciesName, false, 1);
      return this;
    }

    /**
     * Specify that the next attribute to index will be {@link Tree#species() species}, in the descending direction.
     * @return {@code this} indexer for use in a chained invocation
     */
    public Indexer withSpeciesDesceding() {
      fields = fields.equal(serialization.speciesName, false, -1);
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
   * {@code TreeRepository.Criteria} is a Tree document search query.
   * Call methods on the criteria to add constraints for search queries.
   */
  @Generated(from = "Tree", generator = "Repositories")
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

    public Criteria height(int value) {
      return new Criteria(serialization, constraint.equal(serialization.heightName, false, Support.writable(value)));
    }

    public Criteria heightNot(int value) {
      return new Criteria(serialization, constraint.equal(serialization.heightName, true, Support.writable(value)));
    }

    public Criteria heightIn(Iterable<java.lang.Integer> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.Integer value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, false, wrappedValues));
    }

    public Criteria heightIn(int first, int second, int... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (int value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, false, values));
    }

    public Criteria heightNotIn(Iterable<java.lang.Integer> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (java.lang.Integer value : values) {
        wrappedValues.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, true, wrappedValues));
    }

    public Criteria heightNotIn(int first, int second, int... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(first));
      values.add(Support.writable(second));
      for (int value : rest) {
        values.add(Support.writable(value));
      }
      return new Criteria(serialization, constraint.in(serialization.heightName, true, values));
    }

    public Criteria heightGreaterThan(int lower) {
      return heightIn(Range.greaterThan(lower));
    }

    public Criteria heightLessThan(int upper) {
      return heightIn(Range.lessThan(upper));
    }

    public Criteria heightAtMost(int upperInclusive) {
      return heightIn(Range.atMost(upperInclusive));
    }

    public Criteria heightAtLeast(int lowerInclusive) {
      return heightIn(Range.atLeast(lowerInclusive));
    }

    public Criteria heightIn(Range<java.lang.Integer> range) {
      return new Criteria(serialization, constraint.range(serialization.heightName, false, Support.writable(range)));
    }

    public Criteria heightNotIn(Range<java.lang.Integer> range) {
      return new Criteria(serialization, constraint.range(serialization.heightName, true, Support.writable(range)));
    }

    public Criteria species(TreeSpecies value) {
      return new Criteria(serialization, constraint.equal(serialization.speciesName, false, Support.writable(serialization.speciesEncoder, value)));
    }

    public Criteria speciesNot(TreeSpecies value) {
      return new Criteria(serialization, constraint.equal(serialization.speciesName, true, Support.writable(serialization.speciesEncoder, value)));
    }

    public Criteria speciesIn(Iterable<TreeSpecies> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (TreeSpecies value : values) {
        wrappedValues.add(Support.writable(serialization.speciesEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.speciesName, false, wrappedValues));
    }

    public Criteria speciesIn(TreeSpecies first, TreeSpecies second, TreeSpecies... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.speciesEncoder, first));
      values.add(Support.writable(serialization.speciesEncoder, second));
      for (TreeSpecies value : rest) {
        values.add(Support.writable(serialization.speciesEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.speciesName, false, values));
    }

    public Criteria speciesNotIn(Iterable<TreeSpecies> values) {
      List<Object> wrappedValues = new ArrayList<>();
      for (TreeSpecies value : values) {
        wrappedValues.add(Support.writable(serialization.speciesEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.speciesName, true, wrappedValues));
    }

    public Criteria speciesNotIn(TreeSpecies first, TreeSpecies second, TreeSpecies... rest) {
      List<Object> values = new ArrayList<>(2 + rest.length);
      values.add(Support.writable(serialization.speciesEncoder, first));
      values.add(Support.writable(serialization.speciesEncoder, second));
      for (TreeSpecies value : rest) {
        values.add(Support.writable(serialization.speciesEncoder, value));
      }
      return new Criteria(serialization, constraint.in(serialization.speciesName, true, values));
    }

    public Criteria speciesGreaterThan(TreeSpecies lower) {
      return speciesIn(Range.greaterThan(lower));
    }

    public Criteria speciesLessThan(TreeSpecies upper) {
      return speciesIn(Range.lessThan(upper));
    }

    public Criteria speciesAtMost(TreeSpecies upperInclusive) {
      return speciesIn(Range.atMost(upperInclusive));
    }

    public Criteria speciesAtLeast(TreeSpecies lowerInclusive) {
      return speciesIn(Range.atLeast(lowerInclusive));
    }

    public Criteria speciesIn(Range<TreeSpecies> range) {
      return new Criteria(serialization, constraint.range(serialization.speciesName, false, Support.writable(serialization.speciesEncoder, range)));
    }

    public Criteria speciesNotIn(Range<TreeSpecies> range) {
      return new Criteria(serialization, constraint.range(serialization.speciesName, true, Support.writable(serialization.speciesEncoder, range)));
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
      return "TreeRepository.criteria(" + Support.stringify(constraint) + ")";
    }
  }

  @Generated(from = "Tree", generator = "Repositories")
  private static class Serialization {
    final Encoder<TreeSpecies> speciesEncoder;
    final CodecRegistry registry;
    final String idName;
    final String heightName;
    final String speciesName;

    Serialization(CodecRegistry registry, RepositorySetup.FieldNamingStrategy fieldNamingStrategy) {
      this.registry = registry;
      this.speciesEncoder = this.registry.get(TreeSpecies.class);
      this.idName = "_id";
      this.heightName = translateName(fieldNamingStrategy, "height");
      this.speciesName = translateName(fieldNamingStrategy, "species");
    }

    @Generated(from = "Tree", generator = "Repositories")
    static final class TreeNamingFields {
      public long id;
      public int height;
      public TreeSpecies species;
    }

    private static String translateName(RepositorySetup.FieldNamingStrategy fieldNamingStrategy, String fieldName) {
      try {
        return fieldNamingStrategy.translateName(
            TreeNamingFields.class.getField(fieldName));
      } catch (NoSuchFieldException noSuchField) {
        throw new AssertionError(noSuchField);
      }
    }
  }
}
