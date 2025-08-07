package org.bookscatalogue.bookscatalaogue.dto.validation;

import jakarta.validation.constraints.NotBlank;

public record AuthorValidationDTO (
        @NotBlank(message = "name field is required")
        String name,

        @NotBlank(message = "biography field is required")
        String biography
) {
}
