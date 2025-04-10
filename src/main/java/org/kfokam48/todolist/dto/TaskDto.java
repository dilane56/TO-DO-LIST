package org.kfokam48.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kfokam48.todolist.model.Statut;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDto {
    @NotNull(message = "Le titre ne doit pas être null")
    @NotBlank(message = "le Titre est Obligatoire")
    private String title;

    @Size(max = 255)
    private String description;

    @NotNull
    private Statut statut;

    public @NotNull(message = "Le titre ne doit pas être null") @NotBlank(message = "le Titre est Obligatoire") String getTitle() {
        return title;
    }

    public void setTitle(@NotNull(message = "Le titre ne doit pas être null") @NotBlank(message = "le Titre est Obligatoire") String title) {
        this.title = title;
    }

    public @Size(max = 255) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255) String description) {
        this.description = description;
    }

    public @NotNull Statut getStatut() {
        return statut;
    }

    public void setStatut(@NotNull Statut statut) {
        this.statut = statut;
    }
}
