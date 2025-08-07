package org.bookscatalogue.bookscatalaogue.dto.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookValidationDTO (
        @NotBlank(message = "title field is required")
        String title,

        @NotBlank(message = "isbn field is required")
        String isbn,

        @NotNull(message = "author field is required")
        Long author_id
) {
}
