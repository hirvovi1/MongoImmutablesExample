package fi.mongo.training;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Item}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableItem.builder()}.
 */
@Generated(from = "Item", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableItem extends Item {
  private final long id;
  private final String name;
  private final ImmutableSet<Integer> values;
  private final @Nullable String comment;

  private ImmutableItem(
      long id,
      String name,
      ImmutableSet<Integer> values,
      @Nullable String comment) {
    this.id = id;
    this.name = name;
    this.values = values;
    this.comment = comment;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public long id() {
    return id;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code values} attribute
   */
  @Override
  public ImmutableSet<Integer> values() {
    return values;
  }

  /**
   * @return The value of the {@code comment} attribute
   */
  @Override
  public Optional<String> comment() {
    return Optional.ofNullable(comment);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Item#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItem withId(long value) {
    if (this.id == value) return this;
    return new ImmutableItem(value, this.name, this.values, this.comment);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Item#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItem withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableItem(this.id, newValue, this.values, this.comment);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Item#values() values}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItem withValues(int... elements) {
    ImmutableSet<Integer> newValue = ImmutableSet.copyOf(Ints.asList(elements));
    return new ImmutableItem(this.id, this.name, newValue, this.comment);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Item#values() values}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of values elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItem withValues(Iterable<Integer> elements) {
    if (this.values == elements) return this;
    ImmutableSet<Integer> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableItem(this.id, this.name, newValue, this.comment);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Item#comment() comment} attribute.
   * @param value The value for comment
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItem withComment(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "comment");
    if (Objects.equals(this.comment, newValue)) return this;
    return new ImmutableItem(this.id, this.name, this.values, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Item#comment() comment} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for comment
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItem withComment(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.comment, value)) return this;
    return new ImmutableItem(this.id, this.name, this.values, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableItem} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableItem
        && equalTo((ImmutableItem) another);
  }

  private boolean equalTo(ImmutableItem another) {
    return id == another.id
        && name.equals(another.name)
        && values.equals(another.values)
        && Objects.equals(comment, another.comment);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}, {@code values}, {@code comment}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Longs.hashCode(id);
    h += (h << 5) + name.hashCode();
    h += (h << 5) + values.hashCode();
    h += (h << 5) + Objects.hashCode(comment);
    return h;
  }

  /**
   * Prints the immutable value {@code Item} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Item")
        .omitNullValues()
        .add("id", id)
        .add("name", name)
        .add("values", values)
        .add("comment", comment)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Item} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Item instance
   */
  public static ImmutableItem copyOf(Item instance) {
    if (instance instanceof ImmutableItem) {
      return (ImmutableItem) instance;
    }
    return ImmutableItem.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableItem ImmutableItem}.
   * <pre>
   * ImmutableItem.builder()
   *    .id(long) // required {@link Item#id() id}
   *    .name(String) // required {@link Item#name() name}
   *    .addValues|addAllValues(int) // {@link Item#values() values} elements
   *    .comment(String) // optional {@link Item#comment() comment}
   *    .build();
   * </pre>
   * @return A new ImmutableItem builder
   */
  public static ImmutableItem.Builder builder() {
    return new ImmutableItem.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableItem ImmutableItem}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Item", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private long id;
    private @Nullable String name;
    private ImmutableSet.Builder<Integer> values = ImmutableSet.builder();
    private @Nullable String comment;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Item} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Item instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.id());
      name(instance.name());
      addAllValues(instance.values());
      Optional<String> commentOptional = instance.comment();
      if (commentOptional.isPresent()) {
        comment(commentOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Item#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(long id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Item#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Adds one element to {@link Item#values() values} set.
     * @param element A values element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addValues(int element) {
      this.values.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Item#values() values} set.
     * @param elements An array of values elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addValues(int... elements) {
      this.values.addAll(Ints.asList(elements));
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Item#values() values} set.
     * @param elements An iterable of values elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder values(Iterable<Integer> elements) {
      this.values = ImmutableSet.builder();
      return addAllValues(elements);
    }

    /**
     * Adds elements to {@link Item#values() values} set.
     * @param elements An iterable of values elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllValues(Iterable<Integer> elements) {
      this.values.addAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link Item#comment() comment} to comment.
     * @param comment The value for comment
     * @return {@code this} builder for chained invocation
     */
    public final Builder comment(String comment) {
      this.comment = Objects.requireNonNull(comment, "comment");
      return this;
    }

    /**
     * Initializes the optional value {@link Item#comment() comment} to comment.
     * @param comment The value for comment
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder comment(Optional<String> comment) {
      this.comment = comment.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableItem ImmutableItem}.
     * @return An immutable instance of Item
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableItem build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableItem(id, name, values.build(), comment);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build Item, some of required attributes are not set " + attributes;
    }
  }
}
