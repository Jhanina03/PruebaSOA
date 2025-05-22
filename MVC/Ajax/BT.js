$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});

$(document).ready(() => {
    $.ajax({
        url: "../Controllers/APIRest.php",
        type: "GET",
        dataType: "json",
        success: (data) => {
            let tbody = $("#dg tbody");
            tbody.empty()
            data.forEach(estudiante => {
                let row = `
    <tr>
        <td>${estudiante.cedula}</td>
        <td>${estudiante.nombre}</td>
        <td>${estudiante.apellido}</td>
        <td>${estudiante.direccion}</td>
        <td>${estudiante.telefono}</td>
        <td>
            <a href="#editEmployeeModal" class="edit" data-toggle="modal" data-id=${estudiante.cedula}
                data-nombre=${estudiante.nombre} data-apellido=${estudiante.apellido}
                data-direccion=${estudiante.direccion} data-telefono=${estudiante.telefono}>
                <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
            </a>

            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
        </td>
    </tr>
                `;
                tbody.append(row);
            });
        },
        error: function (xhr, status, error) {
            console.error("Error cargando datos:", error);
        }
    })
})

$(document).ready(() => {
    $('#fm').submit((event) => {
        event.preventDefault()
        let formData = $('#fm').serialize()
        let form = this
        $.ajax({
            url: "../Controllers/APIRest.php",
            type: "POST",
            data: formData,
            dataType: "json",
            success: (response) => {
                // $('#dg').datagrid('reload')
                window.location.reload()
                $('#dlg').dialog('close')
                $('#fm').form('clear')
            },
            error: (error) => console.error(error)
        })
    })
})

$(document).on('click', '.delete', function () {
    let row = $(this).closest('tr');
    let cedula = row.find('td').eq(0).text()
    console.log(cedula)
    $('#deleteEmployeeModal button.btn-danger').data('cedula', cedula);
});

$(document).ready(() => {
    $.ajax.deleteEstudiante = () => {
        let cedula = $('#deleteEmployeeModal button.btn-danger').data('cedula')
        console.log(cedula)
        if (cedula) {
            $.ajax({
                url: "../Controllers/APIRest.php?key=" + cedula,
                type: "DELETE",
                // data: formData,
                dataType: "json",
                success: (response) => {
                    // $('#dg').datagrid('reload')
                    window.location.reload()
                    $('#dlg').dialog('close')
                    $('#fm').form('clear')
                },
                error: (error) => console.log(error)
            })
        }
    }
})
$(document).on('click', '.edit', function () {
    let row = $(this).closest('tr');
    let data = []
    for (let index = 0; index < 5; index++) {
        const element = row.find('td').eq(index).text();
        data.push(element)
    }
    $("#cedulaNew").val(data[0])
    $("#nombreNew").val(data[1])
    $("#apellidoNew").val(data[2])
    $("#direccionNew").val(data[3])
    $("#telefonoNew").val(data[4])

});

$(document).ready(() => {
    $.ajax.updateEstudiante = () => {
        let cedula = $('#cedulaNew').val()
        console.log(cedula)
        if (cedula) {
            $('#fme').off().on('submit', (event) => {
                event.preventDefault()
                let formData = $('#fme').serialize()
                console.log(formData)
                let form = this
                $.ajax({
                    url: "../Controllers/APIRest.php?key=" + cedula,
                    type: "PUT",
                    data: formData,
                    dataType: "json",
                    success: (response) => {
                        window.location.reload()
                    },
                    error: (error) => {
                        console.error(error);
                    }
                });
            })
        }
    }
})