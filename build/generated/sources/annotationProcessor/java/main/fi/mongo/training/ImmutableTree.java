package fi.mongo.training;

import com.google.common.base.MoreObjects;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Tree}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTree.builder()}.
 */
@Generated(from = "Tree", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableTree extends Tree {
  private final long id;
  private final int height;
  private final TreeSpecies species;

  private ImmutableTree(long id, int height, TreeSpecies species) {
    this.id = id;
    this.height = height;
    this.species = species;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public long id() {
    return id;
  }

  /**
   * @return The value of the {@code height} attribute
   */
  @Override
  public int height() {
    return height;
  }

  /**
   * @return The value of the {@code species} attribute
   */
  @Override
  public TreeSpecies species() {
    return species;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tree#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTree withId(long value) {
    if (this.id == value) return this;
    return new ImmutableTree(value, this.height, this.species);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tree#height() height} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for height
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTree withHeight(int value) {
    if (this.height == value) return this;
    return new ImmutableTree(this.id, value, this.species);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tree#species() species} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for species
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTree withSpecies(TreeSpecies value) {
    if (this.species == value) return this;
    TreeSpecies newValue = Objects.requireNonNull(value, "species");
    if (this.species.equals(newValue)) return this;
    return new ImmutableTree(this.id, this.height, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTree} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTree
        && equalTo((ImmutableTree) another);
  }

  private boolean equalTo(ImmutableTree another) {
    return id == another.id
        && height == another.height
        && species.equals(another.species);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code height}, {@code species}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Longs.hashCode(id);
    h += (h << 5) + height;
    h += (h << 5) + species.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Tree} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Tree")
        .omitNullValues()
        .add("id", id)
        .add("height", height)
        .add("species", species)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Tree} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Tree instance
   */
  public static ImmutableTree copyOf(Tree instance) {
    if (instance instanceof ImmutableTree) {
      return (ImmutableTree) instance;
    }
    return ImmutableTree.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTree ImmutableTree}.
   * <pre>
   * ImmutableTree.builder()
   *    .id(long) // required {@link Tree#id() id}
   *    .height(int) // required {@link Tree#height() height}
   *    .species(fi.mongo.training.TreeSpecies) // required {@link Tree#species() species}
   *    .build();
   * </pre>
   * @return A new ImmutableTree builder
   */
  public static ImmutableTree.Builder builder() {
    return new ImmutableTree.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTree ImmutableTree}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Tree", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_HEIGHT = 0x2L;
    private static final long INIT_BIT_SPECIES = 0x4L;
    private long initBits = 0x7L;

    private long id;
    private int height;
    private @Nullable TreeSpecies species;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Tree} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Tree instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.id());
      height(instance.height());
      species(instance.species());
      return this;
    }

    /**
     * Initializes the value for the {@link Tree#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(long id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Tree#height() height} attribute.
     * @param height The value for height 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder height(int height) {
      this.height = height;
      initBits &= ~INIT_BIT_HEIGHT;
      return this;
    }

    /**
     * Initializes the value for the {@link Tree#species() species} attribute.
     * @param species The value for species 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder species(TreeSpecies species) {
      this.species = Objects.requireNonNull(species, "species");
      initBits &= ~INIT_BIT_SPECIES;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTree ImmutableTree}.
     * @return An immutable instance of Tree
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTree build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTree(id, height, species);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_HEIGHT) != 0) attributes.add("height");
      if ((initBits & INIT_BIT_SPECIES) != 0) attributes.add("species");
      return "Cannot build Tree, some of required attributes are not set " + attributes;
    }
  }
}
