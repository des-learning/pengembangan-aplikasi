package contohjavafx;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ContohEvent extends Application implements Initializable {
    @FXML
    private TextField txtNama;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<String> lstNama;

    @FXML
    private Label lblItems;

    private ListProperty<String> namas;

    private BooleanProperty addNew;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ContohEvent.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Contoh Event, Property & Binding");
        stage.show();

        // handler untuk aplikasi ditutup
        stage.setOnCloseRequest(this::close);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // add new or update mode
        addNew = new SimpleBooleanProperty();
        // listen to add new value
        addNew.addListener(this::changeMode);
        // set initial mode to add new
        addNewMode();

        // button default button property set the label according to the addNew

        // initialize list view model
        namas = new SimpleListProperty<>(this, "namas", FXCollections.observableArrayList());
        lstNama.setItems(namas);

        // set placeholder ketika list kosong
        lstNama.setPlaceholder(new Label("Data Kosong"));
        // jika item list di pilih
        lstNama.setOnMouseClicked(this::onSelectedItem);
        // jika tombol di tekan pada list
        lstNama.setOnKeyReleased(this::onListKey);

        // lblitems text property bind to size of the namas
        lblItems.textProperty().bind(namas.sizeProperty().asString());

        // escape on txtnama, batal update jika lagi dimode update
        txtNama.setOnKeyReleased(this::onInputKey);

        // focus on txtNama
        txtNama.requestFocus();
    }

    // ketika tombol save di tekan dan mode addNew
    private void onAddNew(Event event) {
        addItem(txtNama.getText());
        clearAndFocus();
    }

    // ketika tombol save di tekan dan mode update
    private void onUpdate(Event event) {
        // get selected item index
        int index = this.lstNama.getSelectionModel().getSelectedIndex();
        // jika ada
        if (index >= 0) {
            // update item
            updateItem(index, txtNama.getText());
            clearAndFocus();
            // kembali ke add new mode
            addNewMode();
        }
    }

    // clear txtNama dan kembalikan fokus ke txtNama
    private void clearAndFocus() {
        txtNama.clear();
        txtNama.requestFocus();
    }

    // ubah ke edit mode
    private void editMode() {
        this.addNew.set(false);
    }

    // add new mode
    private void addNewMode() {
        this.addNew.set(true);
    }

    // handler mouse click di list
    private void onSelectedItem (MouseEvent event) {
        // jika double click, edit item
        if (event.getClickCount() == 2) {
            edit();
        } else {
            // batal edit
            addNewMode();
            txtNama.clear();
        }
    }

    // edit selected item
    private void edit() {
        editMode();
        this.txtNama.setText(lstNama.getSelectionModel().getSelectedItem());
        this.txtNama.requestFocus();
    }

    // tombol keyboard pada list
    private void onListKey(KeyEvent event) {
        // delete key
        if (event.getCode() == KeyCode.DELETE && this.lstNama.getSelectionModel().getSelectedIndex() >= 0) {
            String content = "Yakin delete " + namas.get(this.lstNama.getSelectionModel().getSelectedIndex()) + "?";
            if (confirmDialog("Delete", content) == ButtonType.OK)
                deleteItem(this.lstNama.getSelectionModel().getSelectedIndex());
            // enter key
        } else if (event.getCode() == KeyCode.ENTER && lstNama.getFocusModel().getFocusedIndex() >= 0) {
            edit();
            // escape key
        } else if (event.getCode() == KeyCode.ESCAPE) {
            addNewMode();
            txtNama.clear();
            txtNama.requestFocus();
        }
    }

    // ketika property addnew diganti
    private void changeMode(ObservableValue observableValue, Boolean oldValue, Boolean newValue) {
        // if addNew == true, set button action to add new, else set it to update
        if (newValue) {
            this.btnSave.setText("Add New");
            this.btnSave.setOnAction(this::onAddNew);
        } else {
            this.btnSave.setText("Update");
            this.btnSave.setOnAction(this::onUpdate);
        }
    }

    // input key pada text field
    private void onInputKey(KeyEvent event) {
        // escape key
        if (event.getCode() == KeyCode.ESCAPE && ! addNew.get()) {
            addNewMode();
            txtNama.clear();
            // enter key
        } else if (event.getCode() == KeyCode.ENTER) {
            btnSave.fire();
            // tombol panah bawah
        } else if (event.getCode() == KeyCode.DOWN && namas.size() > 0) {
            this.lstNama.requestFocus();
        }
    }

    // tambahkan item
    private void addItem(String item) {
        namas.add(item);
    }

    // update item
    private void updateItem(int index, String item) {
        namas.set(index, item);
    }

    // hapus item
    private void deleteItem(int index) {
        namas.remove(index);
    }

    // ketika stage di tutup
    private void close(Event event) {
        // jika di cancel, consume event (jangan dibiarkan bubble ke parent)
        // secara efektif event close tidak sampai ke stage sehingga proses close tidak dijalankan
        if (confirmDialog("Keluar", "Yakin keluar?") == ButtonType.CANCEL)
            event.consume();
    }

    // menampilkan dialog konfirmasi dengan tombol ok dan cancel
    private ButtonType confirmDialog(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(header);
        alert.setContentText(content);
        // show and wait return Optional<ButtonType>, nilainya bisa kosong (empty) atau button type.
        // jika kosong kembalikan tombol cancel
        return alert.showAndWait().orElse(ButtonType.CANCEL);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
