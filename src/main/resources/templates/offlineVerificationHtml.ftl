<table style="width:100%">
<tr>
<#list dataFields as dataField>
    <td>${dataField.fieldName}</td>
    <td>${dataField.fieldValue}</td>
</#list>
</tr>
</table>