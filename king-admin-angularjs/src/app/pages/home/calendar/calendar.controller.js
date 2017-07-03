/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
    'use strict';

    angular.module('KingAdmin.pages.home')
        .controller('CalendarControlller', CalendarControlller);

    /** @ngInject */
    function CalendarControlller(baConfig, CalendarService) {
        var dashboardColors = baConfig.colors.dashboard;
        CalendarService.getList({}, function (data) {
            var list = data.result;
            var $element = $('#calendar').fullCalendar({
                //height: 335,
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
                },
                monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
                dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
                today: ["今天"],
                firstDay: 1,
                buttonText: {
                    today: '本月',
                    month: '月',
                    week: '周',
                    day: '日',
                    prev: '上一月',
                    next: '下一月'
                },
                selectable: true,
                selectHelper: true,
                select: function (start, end) {
                    var title = prompt('标注:');
                    var eventData;
                    if (title) {
                        eventData = {
                            title: title,
                            start: start,
                            end: end,
                            color: dashboardColors.blueStone
                        };
                        CalendarService.save(eventData, function (data) {
                            $element.fullCalendar('renderEvent', eventData, true); // stick? = true
                        })
                    }
                    $element.fullCalendar('unselect');
                },
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                events: list
            });
        })
    }
})();