package com.compiler;

import java.util.Objects;

public class ClassNameEntity {

  public String getName() {
    return String.format("[%s:]", name);
  }

  private final String name;

  public ClassNameEntity(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassNameEntity that = (ClassNameEntity) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
