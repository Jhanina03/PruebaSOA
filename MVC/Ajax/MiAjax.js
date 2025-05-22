$(document).ready(() => {
    $.ajax({
        url: "../Controllers/APIRest.php",
        type: "GET",
        dataType: "json",
        success: (data) => {
            $('#dg').datagrid('loadData', data)
            $('#dg').datagrid('reload')
        },
        error: (error) => console.log(error)
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
            error: (error) => console.log(error)
        })
    })
})
$(document).ready(() => {
    $.ajax.deleteEstudiante = () => {
        let row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
                if (r) {
                    $.ajax({
                        url: "../Controllers/APIRest.php?key=" + row.cedula,
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
            })
        }
    }
})
$(document).ready(() => {
    $.ajax.updateEstudiante = () => {
        let row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'Edit User');
            $('#fm').form('load', row);
            $('#fm').off().on('submit', (event) => {
                event.preventDefault()
                let formData = $('#fm').serialize()
                let form = this
                $.ajax({
                    url: "../Controllers/APIRest.php?key=" + row.cedula,
                    type: "PUT",
                    data: formData,
                    dataType: "json",
                    success: (response) => {
                        $('#dg').datagrid('reload');
                        $('#dlg').dialog('close');
                        $('#fm').form('clear');
                        window.location.reload()
                    },
                    error: (error) => {
                        console.error(error);
                        $.messager.show({
                            title: 'Error',
                            msg: 'Hubo un error al conectar con el servidor.'
                        });
                    }
                });
            })
        }
    }
})

function eliminarDatos(cedula) {
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
function updateEstudiante() {
    const cedula = $('input[name="cedula"]')
    const formData = {
        cedula : $('input[name="cedula"]').val(),
        nombre : $('input[name="nombre"]').val(),
        apellido : $('input[name="apellido"]').val(),
        direccion : $('input[name="direccion"]').val(),
        telefono : $('input[name="telefono"]').val()
    }
    console.log(cedula);
    console.log(formData); 
    $.ajax({
        url: "../Controllers/APIRest.php?key="+cedula,
        type: "PUT",
        data: JSON.stringify(formData),
        dataType: "application/json",
        success: (response) => {
            $('#dg').datagrid('reload');
            $('#dlg').dialog('close');
            $('#fm').form('clear');
            window.location.reload()
        },
        error: (error) => {
            console.error(error);
            $.messager.show({
                title: 'Error',
                msg: 'Hubo un error al conectar con el servidor.'
            });
        }
    });
}