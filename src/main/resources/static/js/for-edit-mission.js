$(function () {
    var checked_ids = {"mission_id": $("#input-mission").val(), "target_ids": [], "monitor_ids": [], "uav_ids": []};
    $(".target_checkbox").click(function () {
        $(".target_checkbox:checked").each(function () {
            checked_ids["target_ids"].push($(this).val());
        });
    });
    $(".monitor_checkbox").click(function () {
        $(".monitor_checkbox:checked").each(function () {
            checked_ids["monitor_ids"].push($(this).val());
        });
    });
    $(".uav_checkbox").click(function () {
        $(".uav_checkbox:checked").each(function () {
            checked_ids["uav_ids"].push($(this).val());
        });
    });
    $(".btn-check-target").click(function () {
        if (checked_ids["target_ids"].length <= 0)
            return;
        if (confirm("确认提交？")) {
            $.ajax({
                type:"POST",
                url:"/check_target_finish",
                data: JSON.stringify(checked_ids),
                dataType: "json",
                contentType:"application/json"
            });
        }
    });
    $(".btn-check-monitor").click(function () {
        if (checked_ids["monitor_ids"].length <= 0)
            return;
        if (confirm("确认提交？")) {
            $.ajax({
                type:"POST",
                url:"/check_monitor_finish",
                data: JSON.stringify(checked_ids),
                dataType: "json",
                contentType:"application/json"
            });
        }
    });
    $(".btn-check-uav").click(function () {
        if (checked_ids["uav_ids"].length <= 0)
            return;
        if (confirm("确认提交？")) {
            $.ajax({
                type:"POST",
                url:"/check_uav_finish",
                data: JSON.stringify(checked_ids),
                dataType: "json",
                contentType:"application/json"
            });
        }
    });
});